package biz;

import dao.CommentDao;
import dao.CommentDaoImp;
import entity.Comment;
import util.BaseDao;

import java.util.List;

/**
 * Created with IDEA
 * USER:ckzippo
 * Date:10/7/16
 * TIME:3:25 PM
 */
public class CommentBizImp extends BaseDao implements CommentBiz {
    /**
     * 增加留言
     * @param comment 留言信息
     * @return 成功 true, 失败 false
     */
    public boolean addComment(Comment comment) {
        CommentDao commentDao = new CommentDaoImp();
        return commentDao.insertComment(comment) == 1;
    }

    /**
     * 删除留言(根据留言ID)
     * @param comment 留言信息
     * @return 成功 true ,失败 false
     */
    public boolean delComment(Comment comment) {
        CommentDao commentDao = new CommentDaoImp();
        return commentDao.deleteComment(comment) == 1;
    }

    /**
     * 修改留言(根据留言ID)
     * @param comment 留言信息
     * @return 成功 true, 失败 false
     */
    public boolean modComment(Comment comment) {
        CommentDao commentDao = new CommentDaoImp();
        return commentDao.updateComment(comment) == 1;
    }

    /**
     * 根据留言ID查询留言信息
     * @param id 留言ID
     * @return 留言信息
     */
    public Comment getCommentById(int id) {
        CommentDao commentDao = new CommentDaoImp();
        return commentDao.selectCommentById(id);
    }

    /**
     * 获取留言总数
     * @return 留言总数
     */
    public int getCommentCounts() {
        CommentDao commentDao = new CommentDaoImp();
        return commentDao.getTotalCount();
    }

    /**
     * 获取分页展示留言信息
     * @param pageIndex 页码
     * @param pageSize 页大小
     * @return 每页展示留言信息
     */
    public List<Comment> getCommentsByPage(int pageIndex, int pageSize) {
        CommentDao commentDao = new CommentDaoImp();
        return commentDao.getPageList(pageIndex, pageSize);
    }
}
