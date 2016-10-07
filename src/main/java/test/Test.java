package test;

import biz.*;
import dao.UserDao;
import dao.UserDaoImp;
import entity.*;
import util.BaseDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IDEA
 * USER:ckzippo
 * Date:9/28/16
 * TIME:7:52 AM
 */
public class Test {
    public static void main(String[] args) {
        User lisi = new User();
        lisi.setEu_user_id(4);
        lisi.setEu_user_name("wowwowo");
        lisi.setEu_password("2222");
        lisi.setEu_address("中央路260号");
        lisi.setEu_birthday("1900-01-01");
        lisi.setEu_email("test@189.cn");
        lisi.setEu_identity_code("1234567890111213");
        lisi.setEu_mobile("1388888888");
        lisi.setEu_sex(Sex.MALE.getSex());
        lisi.setEu_status(OrderStatus.ALLOCATION.getStatus());
        System.out.println(lisi);
        lisi.setEu_headimage("wowowo");


 /*       UserBiz userBiz = new UserBizImp();
        userBiz.modUser(lisi);
//        System.out.println(userBiz.getUserById(4));
        *//*List<User> list = userBiz.getUsersByPage(1,6);
        for (User user :
                list) {
            System.out.println(user);
        }*//*
//        System.out.println(userBiz.getUserCounts());
//        userBiz.addUser(lisi);
//        System.out.println(userBiz.validateUser("越前平次", "1234"));*/


        //商品操作
        Product product = new Product();
        product.setEp_name("电话");
        product.setEp_description("wwwwwww");
        product.setEp_price("15");
        product.setEp_stock("111");
        product.setEpc_id(1);
        product.setEpc_child_id(2);
        product.setEp_file_name("ddddd/");
        product.setEp_id(2);
        product.setEp_barcode("111122223333");


       /* Product product1 = new Product();
        product1.setEp_id(1);
        ProductBiz productBiz = new ProductBizImp();
        if (productBiz.addProduct(product)) {
            System.out.println("插入成功");
        } else {
            System.out.println("插入失败");
        }

        List<Product> list = new ArrayList<Product>();
        list = productBiz.getProductsByPage(1,10);
        for (Product product2 :
                list) {
            System.out.println(product2);
        }*/


       //商品分类操作
        ProductCategory productCategory = new ProductCategory();
        productCategory.setEpc_name("冰箱");
        productCategory.setEpc_parent_id(1);

        ProductCategoryBiz productCategoryBiz = new ProductCategoryBizImp();
       /* if (productCategoryBiz.addProductCategory(productCategory)) {
            System.out.println("插入分类成功");
        } else {
            System.out.println("插入分类失败");
        }*/
       List<ProductCategory> list = productCategoryBiz.getProductCategoriesByParentId(1);
        for (ProductCategory pro :
                list) {
            System.out.println(pro);
        }

    }
}
