package dao;

import entity.Comment;
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
 * Date:10/7/16
 * TIME:3:19 PM
 */

/**
 * 留言对象数据库实现类
 */
public class CommentDaoImp extends BaseDao implements CommentDao{
    /**
     * 插入留言
     * @param comment 留言对象
     * @return 成功 1 , 失败 0
     */
    public int insertComment(Comment comment) {
        int result = 0;
        //插入语句
        String sql = "insert into easybuy_comment(ec_reply,ec_content,ec_create_time,ec_reply_time,ec_nick_name)"
                + "values(?,?,?,?,?)";

        //SQL参数
        Object[] param = {
                comment.getEc_reply(),
                comment.getEc_content(),
                comment.getEc_create_time(),
                comment.getEc_reply_time(),
                comment.getEc_nick_name()
        };

        result = executeUpdate(sql, param);

        return (result > 0) ? 1 : 0;
    }

    /**
     * 删除留言(根据ID)
     * @param comment 留言对象
     * @return 成功1 , 失败0
     */
    public int deleteComment(Comment comment) {
        int result = 0;
        String sql = "delete from easybuy_comment where ec_id = ?";
        Object[] param = {comment.getEc_id()};
        result = executeUpdate(sql, param);
        return (result > 0) ? 1 : 0;
    }

    /**
     * 更新留言对象
     * @param comment 留言对象
     * @return 成功 1, 失败 0
     */
    public int updateComment(Comment comment) {
        int result = 0;
        String sql = "update easybuy_comment set ec_reply=?,ec_content=?,ec_create_time=?,ec_reply_time=?,ec_nick_name=?"
                + " where ec_id=?";
        Object[] param = {
                comment.getEc_reply(),
                comment.getEc_content(),
                comment.getEc_create_time(),
                comment.getEc_reply_time(),
                comment.getEc_nick_name(),
                comment.getEc_id()
        };
        result = executeUpdate(sql, param);
        return (result > 0) ? 1 : 0;
    }

    /**
     * 根据留言ID,查询留言信息
     * @param id 留言ID
     * @return 留言信息
     */
    public Comment selectCommentById(int id) {
        Comment comment = new Comment();
        String sql = "select * from easybuy_comment where ec_id = ?";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                comment.setEc_id(resultSet.getInt("ec_id"));
                comment.setEc_reply(resultSet.getString("ec_reply"));
                comment.setEc_content(resultSet.getString("ec_content"));
                comment.setEc_create_time(resultSet.getString("ec_create_time"));
                comment.setEc_reply_time(resultSet.getString("ec_reply_time"));
                comment.setEc_nick_name(resultSet.getString("ec_nick_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(connection, preparedStatement, resultSet);
        }
        return comment;
    }

    /**
     * 返回系统留言总数
     * @return 留言总数
     */
    public int getTotalCount() {
        String sql = "select count(*) from easybuy_comment";

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
     * 分页展示留言信息
     * @param pageIndex 页码
     * @param pageSize 页大小
     * @return 每页留言信息
     */
    public List<Comment> getPageList(int pageIndex, int pageSize) {
        List<Comment> list = new ArrayList<Comment>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // 打开连接
            conn = getConnection();
            // 创建查询sql语句
            StringBuffer selectSql = new StringBuffer();
            selectSql.append("select ec_id,ec_reply,ec_content,"
                    + "ec_create_time,ec_reply_time,ec_nick_name"
                    + " from easybuy_comment");
            selectSql.append(" limit ");
            selectSql.append((pageIndex - 1) * pageSize);
            selectSql.append(",");
            selectSql.append(pageSize);

            // 创建PreparedStatment接口
            pstmt = conn.prepareStatement(selectSql.toString());
            // 创建ResultSet结果集对象接收返回结果集
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Comment comment = new Comment();
                comment.setEc_id(rs.getInt("ec_id"));
                comment.setEc_reply(rs.getString("ec_reply"));
                comment.setEc_content(rs.getString("ec_content"));
                comment.setEc_create_time(rs.getString("ec_create_time"));
                comment.setEc_reply_time(rs.getString("ec_reply_time"));
                comment.setEc_nick_name(rs.getString("ec_nick_name"));
                list.add(comment);
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
