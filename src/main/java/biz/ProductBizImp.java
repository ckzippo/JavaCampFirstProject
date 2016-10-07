package biz;

import dao.ProductDao;
import dao.ProductDaoImp;
import entity.Product;

import java.util.List;

/**
 * Created with IDEA
 * USER:ckzippo
 * Date:10/7/16
 * TIME:10:07 AM
 */
public class ProductBizImp implements ProductBiz {

    /**
     * 增加商品
     * @param product 商品信息
     * @return 成功 true, 失败 false
     */
    public boolean addProduct(Product product) {
        ProductDao productDao = new ProductDaoImp();
        return productDao.insertProduct(product) == 1;
    }

    /**
     * 删除商品(根据商品ID)
     * @param product 商品信息
     * @return 成功 true, 失败 false
     */
    public boolean delProduct(Product product) {
        ProductDao productDao = new ProductDaoImp();
        return productDao.deleteProduct(product) == 1;
    }

    /**
     * 修改商品(根据商品ID)
     * @param product 商品信息
     * @return 成功 true, 失败 false
     */
    public boolean modProduct(Product product) {
        ProductDao productDao = new ProductDaoImp();
        return productDao.updateProduct(product) == 1;
    }

    /**
     * 根据商品ID获取商品信息
     * @param id 商品ID
     * @return 商品信息
     */
    public Product getProductById(int id) {
        ProductDao productDao = new ProductDaoImp();
        return productDao.selectProductById(id);
    }

    /**
     * 获取商品总数
     * @return 商品总数
     */
    public int getProductCounts() {
        ProductDao productDao = new ProductDaoImp();
        return productDao.getTotalCount();
    }

    /**
     * 分页获取商品信息
     * @param pageIndex 页码
     * @param pageSize 分页大小
     * @return 每页商品信息
     */
    public List<Product> getProductsByPage(int pageIndex, int pageSize) {
        ProductDao productDao = new ProductDaoImp();
        return productDao.getPageList(pageIndex, pageSize);
    }
}
