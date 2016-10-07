package biz;

import dao.UserDao;
import dao.UserDaoImp;
import entity.User;

import java.util.List;

/**
 * Created with IDEA
 * USER:ckzippo
 * Date:9/28/16
 * TIME:10:10 AM
 */
public class UserBizImp implements UserBiz {

    /**
     * 增加用户.
     * @param user 用户信息
     * @return 成功 true, 失败 false
     */
    public boolean addUser(final User user) {
        UserDao userDao = new UserDaoImp();
        return userDao.insertUser(user) == 1;
    }

    /**
     * 删除用户 根据用户ID删除用户.
     * @param user 用户信息
     * @return 成功 true, 失败 false
     */
    public boolean delUser(final User user) {
        UserDao userDao = new UserDaoImp();
        return userDao.deleteUser(user) == 1;
    }

    /**
     * 修改用户 根据用户ID修改用户.
     * @param user 用户信息
     * @return 成功 true, 失败 false
     */
    public boolean modUser(final User user) {
        UserDao userDao = new UserDaoImp();
        return userDao.updateUser(user) == 1;
    }

    /**
     * 根据用户ID获取用户信息.
     * @param id 用户ID
     * @return User 用户信息
     */
    public User getUserById(final int id) {
        UserDao userDao = new UserDaoImp();
        return userDao.selectUserById(id);
    }

    /**
     * 根据用户名和密码验证是否成功登陆.
     * @param username 用户名
     * @param password 密码
     * @return 用户名和密码匹配,返回true;否则,false
     */
    public boolean validateUser(final String username, final String password) {
        UserDao userDao = new UserDaoImp();
        return userDao.validateUser(username, password);
    }

    /**
     * 获取用户总数.
     * @return 用户总数
     */
    public int getUserCounts() {
        UserDao userDao = new UserDaoImp();
        return userDao.getTotalCount();
    }

    /**
     * 获取分页用户信息.
     * @param pageIndex 页索引
     * @param pageSize 分页大小
     * @return 分页用户信息
     */
    public List<User> getUsersByPage(final int pageIndex, final int pageSize) {
        UserDao userDao = new UserDaoImp();
        return userDao.getPageList(pageIndex, pageSize);
    }
}


