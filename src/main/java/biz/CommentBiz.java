package biz;

/**
 * Created with IDEA
 * USER:ckzippo
 * Date:10/7/16
 * TIME:3:23 PM
 */

import entity.Comment;

import java.util.List;

/**
 * 留言业务逻辑接口
 */
public interface CommentBiz {
    // 增加留言
    boolean addComment(final Comment comment);

    // 删除留言
    boolean delComment(final Comment comment);

    // 修改留言
    boolean modComment(final Comment comment);

    // 根据留言ID查找留言
    Comment getCommentById(final int id);

    // 获取留言总数
    int getCommentCounts();

    // 获取分页留言数据
    List<Comment> getCommentsByPage(final int pageIndex, final int pageSize);
}
