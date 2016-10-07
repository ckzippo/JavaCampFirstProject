package biz;

import entity.ProductCategory;

import java.util.List;

/**
 * Created with IDEA
 * USER:ckzippo
 * Date:10/7/16
 * TIME:2:18 PM
 */
public interface ProductCategoryBiz {
    // 增加商品分类
    boolean addProductCategory(final ProductCategory productCategory);

    // 删除商品分类
    boolean delProductCategory(final ProductCategory productCategory);

    // 修改商品分类
    boolean modProductCategory(final ProductCategory productCategory);

    // 根据商品分类ID查找商品分类
    ProductCategory getProductCategoryById(final int id);

    // 根据父ID,查询其下所有子分类
    List<ProductCategory> getProductCategoriesByParentId(final int parentid);
}
