package dao;

/**
 * Created with IDEA
 * USER:ckzippo
 * Date:9/27/16
 * TIME:9:49 PM
 */

import entity.User;

import java.util.List;

/**
 * 用户信息数据库接口.
 */
public interface UserDao {

    // 插入用户
    int insertUser(final User user);

    /*删除用户*/
    int deleteUser(final User user);

    /*修改用户*/
    int updateUser(final User user);

    /*根据主键ID查询用户对象*/
    User selectUserById(final int id);

    /*校验用户名密码*/
    boolean validateUser(String username, String password);

    /*查询当前记录总数*/
    int getTotalCount();

    /*查询分页语句*/
    List<User> getPageList(final int pageIndex, final int pageSize);
}
