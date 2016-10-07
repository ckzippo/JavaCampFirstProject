package dao;

/**
 * Created with IDEA
 * USER:ckzippo
 * Date:10/7/16
 * TIME:9:51 AM
 */


import entity.Product;

import java.util.List;

/**
 * 商品操作接口
 */
public interface ProductDao {
    // 插入商品
    int insertProduct(final Product product);

    /*删除商品*/
    int deleteProduct(final Product product);

    /*修改商品*/
    int updateProduct(final Product product);

    /*根据主键ID查询商品对象*/
    Product selectProductById(final int id);

    /*查询当前记录总数*/
    int getTotalCount();

    /*查询分页语句*/
    List<Product> getPageList(final int pageIndex, final int pageSize);
}
