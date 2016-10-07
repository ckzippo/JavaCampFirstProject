package biz;

/**
 * Created with IDEA
 * USER:ckzippo
 * Date:9/28/16
 * TIME:10:08 AM
 */

import entity.User;

import java.util.List;

/**
 * 用户逻辑接口.
 */
public interface UserBiz {

    // 增加用户
    boolean addUser(final User user);

    // 删除用户
    boolean delUser(final User user);

    // 修改用户
    boolean modUser(final User user);

    // 根据用户ID查找用户
    User getUserById(final int id);

    // 验证用户名密码
    boolean validateUser(final String username, final String password);

    // 获取用户总数
    int getUserCounts();

    // 获取分页用户数据
    List<User> getUsersByPage(final int pageIndex, final int pageSize);
}
