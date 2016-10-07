package dao;

import entity.ProductCategory;

import java.util.List;

/**
 * Created with IDEA
 * USER:ckzippo
 * Date:10/7/16
 * TIME:2:11 PM
 */
public interface ProductCategoryDao {
    // 插入商品分类
    int insertProductCategory(final ProductCategory productCategory);

    /*删除商品分类*/
    int deleteProductCategory(final ProductCategory productCategory);

    /*修改商品分类*/
    int updateProductCategory(final ProductCategory productCategory);

    /*根据主键ID查询商品分类对象*/
    ProductCategory selectProductCategoryById(final int id);

    /*选取某个父分类下的所有子分类对象*/
    List<ProductCategory> selectProductCategoriesByParentId(final int parentid);
}
