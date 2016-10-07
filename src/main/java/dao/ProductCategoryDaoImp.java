package dao;

import entity.ProductCategory;
import util.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IDEA
 * USER:ckzippo
 * Date:10/7/16
 * TIME:2:14 PM
 */
public class ProductCategoryDaoImp extends BaseDao implements ProductCategoryDao {

    /**
     * 插入商品分类信息
     * @param productCategory 商品分类信息
     * @return 成功 1, 失败 0
     */
    public int insertProductCategory(ProductCategory productCategory) {
        int result = 0;
        //插入语句
        String sql = "insert into easybuy_product_category(epc_name,epc_parent_id)"
                + "values(?,?)";

        //SQL参数
        Object[] param = {
                productCategory.getEpc_name(),
                productCategory.getEpc_parent_id()
        };

        result = executeUpdate(sql, param);

        return (result > 0) ? 1 : 0;
    }

    /**
     * 删除商品分类信息
     * @param productCategory 商品分类信息
     * @return 成功 1, 失败 0
     * TODO:当删除一个父分类的时候,需要同时删除子分类。递归删除
     */
    public int deleteProductCategory(ProductCategory productCategory) {
        int result = 0;
        String sql = "delete from easybuy_product_category where epc_id = ?";
        Object[] param = {productCategory.getEpc_id()};
        result = executeUpdate(sql, param);
        return (result > 0) ? 1 : 0;
    }

    /**
     * 更新商品分类信息
     * @param productCategory 商品分类信息
     * @return 成功 1 ,失败 0
     */
    public int updateProductCategory(ProductCategory productCategory) {
        int result = 0;
        String sql = "update easybuy_product_category set epc_name=?,epc_parent_id=?"
                + " where epc_id=?";
        Object[] param = {
                productCategory.getEpc_name(),
                productCategory.getEpc_parent_id(),
                productCategory.getEpc_id()
        };
        result = executeUpdate(sql, param);
        return (result > 0) ? 1 : 0;
    }

    /**
     * 根据商品分类ID获取分类信息
     * @param id 分类ID
     * @return 商品分类信息
     */
    public ProductCategory selectProductCategoryById(int id) {
        ProductCategory productCategory = new ProductCategory();
        String sql = "select * from easybuy_product_category where epc_id = ?";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                productCategory.setEpc_id(resultSet.getInt("epc_id"));
                productCategory.setEpc_name(resultSet.getString("epc_name"));
                productCategory.setEpc_parent_id(resultSet.getInt("epc_parent_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(connection, preparedStatement, resultSet);
        }
        return productCategory;
    }

    /**
     * 查询某个父分类下的所有子分类
     * @param parentid
     * @return
     */
    public List<ProductCategory> selectProductCategoriesByParentId(int parentid) {
        List<ProductCategory> list = new ArrayList<ProductCategory>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // 打开连接
            conn = getConnection();
            // 创建查询sql语句
            StringBuffer selectSql = new StringBuffer();
            selectSql.append("select *  from easybuy_product_category where epc_parent_id= " + parentid);

            // 创建PreparedStatment接口
            pstmt = conn.prepareStatement(selectSql.toString());
            // 创建ResultSet结果集对象接收返回结果集
            rs = pstmt.executeQuery();
            while (rs.next()) {
                ProductCategory productCategory = new ProductCategory();
                productCategory.setEpc_id(rs.getInt("epc_id"));
                productCategory.setEpc_name(rs.getString("epc_name"));
                productCategory.setEpc_parent_id(parentid);
                list.add(productCategory);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // 关闭资源
            closeAll(conn, pstmt, rs);
        }

        return list;
    }
}
