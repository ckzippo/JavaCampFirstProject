package dao;

/**
 * Created with IDEA
 * USER:ckzippo
 * Date:10/7/16
 * TIME:3:17 PM
 */

import entity.Comment;

import java.util.List;

/**
 * 留言管理数据库操作接口
 */
public interface CommentDao {
    // 插入留言
    int insertComment(final Comment comment);

    /*删除留言*/
    int deleteComment(final Comment comment);

    /*修改留言*/
    int updateComment(final Comment comment);

    /*根据主键ID查询留言对象*/
    Comment selectCommentById(final int id);

    /*查询当前记录总数*/
    int getTotalCount();

    /*查询分页语句*/
    List<Comment> getPageList(final int pageIndex, final int pageSize);
}
