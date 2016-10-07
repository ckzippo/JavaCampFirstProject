package dao;

import entity.User;
import util.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IDEA
 * USER:ckzippo
 * Date:9/27/16
 * TIME:9:52 PM
 */

/**
 * 用户对象数据库操作实现类.
 */
public class UserDaoImp extends BaseDao implements UserDao {
    /**
     * 插入用户.
     * @param user 用户对象
     * @return 0 失败,1 成功
     */
    public int insertUser(final User user) {
        int result = 0;
        //插入语句
        String sql = "insert into easybuy_user(eu_user_name,eu_password,"
                + "eu_sex,eu_birthday,eu_identity_code,"
                + "eu_email,eu_mobile,eu_address,eu_headimage,eu_status)"
                + "values(?,?,?,?,?,?,?,?,?,?)";

        //SQL参数
        Object[] param = {
                user.getEu_user_name(),
                user.getEu_password(),
                user.getEu_sex(),
                user.getEu_birthday(),
                user.getEu_identity_code(),
                user.getEu_email(),
                user.getEu_mobile(),
                user.getEu_address(),
                user.getEu_headimage(),
                user.getEu_status()
        };

        result = executeUpdate(sql, param);

        return (result > 0) ? 1 : 0;
    }

    /**
     * 删除用户(根据用户ID删除).
     * @param user 用户对象
     * @return 0 失败, 1 成功
     */
    public int deleteUser(final User user) {
        int result = 0;
        String sql = "delete from easybuy_user where eu_user_id = ?";
        Object[] param = {user.getEu_user_id()};
        result = executeUpdate(sql, param);
        return (result > 0) ? 1 : 0;
    }

    /**
     * 更新用户(根据用户ID更新).
     * @param user 用户对象
     * @return 0 失败,1 成功
     */
    public int updateUser(final User user) {
        int result = 0;
        String sql = "update easybuy_user set eu_user_name=?,eu_password=?,eu_sex=?,"
                + "eu_birthday=?,eu_identity_code=?,eu_email=?,eu_mobile=?,eu_address=?,eu_headimage=?,eu_status=?"
                + " where eu_user_id=?";
        Object[] param = {
            user.getEu_user_name(),
                user.getEu_password(),
                user.getEu_sex(),
                user.getEu_birthday(),
                user.getEu_identity_code(),
                user.getEu_email(),
                user.getEu_mobile(),
                user.getEu_address(),
                user.getEu_headimage(),
                user.getEu_status(),
                user.getEu_user_id()
        };
        result = executeUpdate(sql, param);
        return (result > 0) ? 1 : 0;
    }

    /**
     * 根据用户ID查询指定用户.
     * @param id 用户ID
     * @return 用户对象
     */
    public User selectUserById(int id) {
        User user = new User();
        String sql = "select * from easybuy_user where eu_user_id = ?";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user.setEu_user_id(resultSet.getInt("eu_user_id"));
                user.setEu_user_name(resultSet.getString("eu_user_name"));
                user.setEu_password(resultSet.getString("eu_password"));
                user.setEu_sex(resultSet.getInt("eu_sex"));
//                user.setEu_birthday(resultSet.getTime("eu_birthday").toString());
                user.setEu_birthday(resultSet.getString("eu_birthday"));
                user.setEu_identity_code(resultSet.getString("eu_identity_code"));
                user.setEu_email(resultSet.getString("eu_email"));
                user.setEu_mobile(resultSet.getString("eu_mobile"));
                user.setEu_address(resultSet.getString("eu_address"));
                user.setEu_headimage(resultSet.getString("eu_headimage"));
                user.setEu_status(resultSet.getInt("eu_status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(connection, preparedStatement, resultSet);
        }
        return user;
    }

    /**
     * 根据用户名和密码校验用户信息.
     * @param username 用户名
     * @param password 密码
     * @return 用户名密码匹配,返回true;否则 false
     */
    public boolean validateUser(final String username, final String password) {
        boolean result = false;
        String sql = "select * from easybuy_user where eu_user_name= '" + username + "' and eu_password='" + password + "'";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(connection, preparedStatement, resultSet);
        }
        return result;
    }

    /**
     * 获取所有用户记录.
     * @return 返回所有用户数目
     */
    public int getTotalCount() {
        String sql = "select count(*) from easybuy_user";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int total = 0;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                total = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(connection, preparedStatement, resultSet);
        }

        return total;
    }

    /**
     * 分页获取用户.
     * @param pageIndex 页索引
     * @param pageSize 每页大小
     * @return 每页用户列表
     */
    public List<User> getPageList(final int pageIndex, final int pageSize) {
        List<User> list = new ArrayList<User>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // 打开连接
            conn = getConnection();
            // 创建查询sql语句
            StringBuffer selectSql = new StringBuffer();
            selectSql.append("select eu_user_id,eu_user_name,eu_password,"
                    + "eu_sex,eu_birthday,eu_identity_code,"
                    + "eu_email,eu_mobile,eu_address,eu_headimage,eu_status from easybuy_user");
            selectSql.append(" limit ");
            selectSql.append((pageIndex - 1) * pageSize);
            selectSql.append(",");
            selectSql.append(pageSize);

            // 创建PreparedStatment接口
            pstmt = conn.prepareStatement(selectSql.toString());
            // 创建ResultSet结果集对象接收返回结果集
            rs = pstmt.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setEu_user_id(rs.getInt("eu_user_id"));
                user.setEu_user_name(rs.getString("eu_user_name"));
                user.setEu_password(rs.getString("eu_password"));
                user.setEu_sex(rs.getInt("eu_sex"));
                user.setEu_birthday(rs.getString("eu_birthday"));
                user.setEu_identity_code(rs.getString("eu_identity_code"));
                user.setEu_email(rs.getString("eu_email"));
                user.setEu_mobile(rs.getString("eu_mobile"));
                user.setEu_address(rs.getString("eu_address"));
                user.setEu_headimage(rs.getString("eu_headimage"));
                user.setEu_status(rs.getInt("eu_status"));

                list.add(user);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // 关闭资源
            closeAll(conn, pstmt, rs);
        }

        return list;
    }
}
