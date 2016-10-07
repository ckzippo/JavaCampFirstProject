package biz;

import dao.ProductCategoryDao;
import dao.ProductCategoryDaoImp;
import entity.ProductCategory;

import java.util.List;

/**
 * Created with IDEA
 * USER:ckzippo
 * Date:10/7/16
 * TIME:2:19 PM
 */
public class ProductCategoryBizImp implements ProductCategoryBiz {
    /**
     * 增加商品分类信息
     * @param productCategory 商品分类
     * @return 成功 true, 失败 false
     */
    public boolean addProductCategory(ProductCategory productCategory) {
        ProductCategoryDao productCategoryDao = new ProductCategoryDaoImp();
        return productCategoryDao.insertProductCategory(productCategory) == 1;
    }

    /**
     * 删除商品分类信息(根据ID删除)
     * @param productCategory 商品分类信息
     * @return 成功 true, 失败 false
     */
    public boolean delProductCategory(ProductCategory productCategory) {
        ProductCategoryDao productCategoryDao = new ProductCategoryDaoImp();
        return productCategoryDao.deleteProductCategory(productCategory) == 1;
    }

    /**
     * 修改商品分类信息(根据ID修改)
     * @param productCategory 商品分类信息
     * @return 成功 true, 失败 false
     */
    public boolean modProductCategory(ProductCategory productCategory) {
        ProductCategoryDao productCategoryDao = new ProductCategoryDaoImp();
        return productCategoryDao.updateProductCategory(productCategory) == 1;
    }

    /**
     * 根据商品分类ID获取商品分类信息
     * @param id 商品分类ID
     * @return 商品分类信息
     */
    public ProductCategory getProductCategoryById(int id) {
        ProductCategoryDao productCategoryDao = new ProductCategoryDaoImp();
        return productCategoryDao.selectProductCategoryById(id);
    }

    /**
     * 根据父分类ID查询其下所有子分类信息
     * @param parentid 父分类ID
     * @return 所有子分类信息
     */
    public List<ProductCategory> getProductCategoriesByParentId(int parentid) {
        ProductCategoryDao productCategoryDao = new ProductCategoryDaoImp();
        return productCategoryDao.selectProductCategoriesByParentId(parentid);
    }
}
