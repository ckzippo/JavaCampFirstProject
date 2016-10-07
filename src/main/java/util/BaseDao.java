package util;

/**
 * Created with IDEA
 * USER:ckzippo
 * Date:9/27/16
 * TIME:9:25 PM
 */

import java.sql.*;

/**
 * 连接MySQL工具类
 */
public class BaseDao {
    private final String className = "com.mysql.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/easybuy?useUnicode=true&characterEncoding=utf-8";
    private final String username = "root";
    private final String password = "Y1ouX2in3";

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    /**
     * 获取一个连接
     * @return Connection
     */
    public Connection getConnection() {
        try {
            Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (connection != null) {
            return connection;
        }else {
            try {
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    /**
     * 关闭资源
     * @param connection 连接
     * @param preparedStatement preparedStatement
     * @param resultSet 结果集
     */
    public void closeAll(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {

        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新操作
     * @param sql   SQL语句
     * @param param 参数
     * @return 受影响的行数
     */
    public int executeUpdate(String sql, Object[] param) {
        int num = 0;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            if (param != null) {
                for (int i = 0; i < param.length; i++) {
                    preparedStatement.setObject(i+1, param[i]);
                }
            }
            num = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(connection, preparedStatement, null);
        }
        return num;
    }


    /**
     * 查看MySQL各个连接的编码字符集。测试用
     * @return MySQL连接字符集
     */
    public String queryMysqlEncoding(){
        StringBuffer result = new StringBuffer();
        try {
            String sql = "show variables LIKE '%char%'";
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result.append(resultSet.getString(1) + "\t" + resultSet.getString(2) + "\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(connection, preparedStatement, resultSet);
        }
        return result.toString();
    }
}
