package biz;

/**
 * Created with IDEA
 * USER:ckzippo
 * Date:10/7/16
 * TIME:10:04 AM
 */

import entity.Product;

import java.util.List;

/**
 * 商品逻辑接口
 */
public interface ProductBiz {
    // 增加商品
    boolean addProduct(final Product product);

    // 删除商品
    boolean delProduct(final Product product);

    // 修改商品
    boolean modProduct(final Product product);

    // 根据商品ID查找商品
    Product getProductById(final int id);

    // 获取商品总数
    int getProductCounts();

    // 获取分页商品数据
    List<Product> getProductsByPage(final int pageIndex, final int pageSize);
}
