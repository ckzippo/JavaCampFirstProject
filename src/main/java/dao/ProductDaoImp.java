package dao;

import entity.Product;
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
 * TIME:9:53 AM
 */

/**
 * 商品对象数据库操作实现类
 */
public class ProductDaoImp extends BaseDao implements ProductDao {

    /**
     * 插入商品
     * @param product 商品对象
     * @return 0 失败, 1 成功
     */
    public int insertProduct(Product product) {
        int result = 0;
        //插入语句
        String sql = "insert into easybuy_product(ep_name,ep_description,"
                + "ep_price,ep_stock,epc_id,"
                + "epc_child_id,ep_file_name,ep_barcode)"
                + "values(?,?,?,?,?,?,?,?)";

        //SQL参数
        Object[] param = {
                product.getEp_name(),
                product.getEp_description(),
                product.getEp_price(),
                product.getEp_stock(),
                product.getEpc_id(),
                product.getEpc_child_id(),
                product.getEp_file_name(),
                product.getEp_barcode()
        };

        result = executeUpdate(sql, param);

        return (result > 0) ? 1 : 0;
    }

    /**
     * 删除商品(根据商品ID删除)
     * @param product 商品对象
     * @return 0 失败, 1 成功
     */
    public int deleteProduct(Product product) {
        int result = 0;
        String sql = "delete from easybuy_product where ep_id = ?";
        Object[] param = {product.getEp_id()};
        result = executeUpdate(sql, param);
        return (result > 0) ? 1 : 0;
    }

    /**
     * 更新商品信息 (根据商品ID更新)
     * @param product 商品对象
     * @return 0 失败, 1 成功
     */
    public int updateProduct(Product product) {
        int result = 0;
        String sql = "update easybuy_product set ep_name=?,ep_description=?,ep_price=?,"
                + "ep_stock=?,epc_id=?,epc_child_id=?,ep_file_name=?,ep_barcode=?"
                + " where ep_id=?";
        Object[] param = {
                product.getEp_name(),
                product.getEp_description(),
                product.getEp_price(),
                product.getEp_stock(),
                product.getEpc_id(),
                product.getEpc_child_id(),
                product.getEp_file_name(),
                product.getEp_barcode(),
                product.getEp_id()
        };
        result = executeUpdate(sql, param);
        return (result > 0) ? 1 : 0;
    }

    /**
     * 根据商品ID查询商品信息
     * @param id 商品ID
     * @return 商品信息
     */
    public Product selectProductById(int id) {
        Product product = new Product();
        String sql = "select * from easybuy_product where ep_id = ?";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                product.setEp_id(resultSet.getInt("ep_id"));
                product.setEp_name(resultSet.getString("ep_name"));
                product.setEp_description(resultSet.getString("ep_description"));
                product.setEp_price(String.valueOf(resultSet.getDouble("ep_price")));
                product.setEp_stock(String.valueOf(resultSet.getInt("ep_stock")));
                product.setEpc_id(resultSet.getInt("epc_id"));
                product.setEpc_child_id(resultSet.getInt("epc_child_id"));
                product.setEp_file_name(resultSet.getString("ep_file_name"));
                product.setEp_barcode(resultSet.getString("ep_barcode"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(connection, preparedStatement, resultSet);
        }
        return product;
    }

    /**
     * 获取商品总数
     * @return 商品总数
     */
    public int getTotalCount() {
        String sql = "select count(*) from easybuy_product";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int total = 0;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                total = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(connection, preparedStatement, resultSet);
        }

        return total;
    }

    /**
     * 分页展示商品信息
     * @param pageIndex 页索引
     * @param pageSize 页大小
     * @return 每页商品信息
     */
    public List<Product> getPageList(int pageIndex, int pageSize) {
        List<Product> list = new ArrayList<Product>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // 打开连接
            conn = getConnection();
            // 创建查询sql语句
            StringBuffer selectSql = new StringBuffer();
            selectSql.append("select ep_id,ep_name,ep_description,"
                    + "ep_price,ep_stock,epc_id,"
                    + "epc_child_id,ep_file_name,ep_barcode from easybuy_product");
            selectSql.append(" limit ");
            selectSql.append((pageIndex - 1) * pageSize);
            selectSql.append(",");
            selectSql.append(pageSize);

            // 创建PreparedStatment接口
            pstmt = conn.prepareStatement(selectSql.toString());
            // 创建ResultSet结果集对象接收返回结果集
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setEp_id(rs.getInt("ep_id"));
                product.setEp_name(rs.getString("ep_name"));
                product.setEp_description(rs.getString("ep_description"));
                product.setEp_price(String.valueOf(rs.getDouble("ep_price")));
                product.setEp_stock(String.valueOf(rs.getInt("ep_stock")));
                product.setEpc_id(rs.getInt("epc_id"));
                product.setEpc_child_id(rs.getInt("epc_child_id"));
                product.setEp_file_name(rs.getString("ep_file_name"));
                product.setEp_barcode(rs.getString("ep_barcode"));
                list.add(product);
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
