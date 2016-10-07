package servlet;

import biz.CommentBiz;
import biz.CommentBizImp;
import entity.Comment;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IDEA
 * USER:ckzippo
 * Date:10/7/16
 * TIME:10:14 PM
 */

/**
 * 删除留言
 */
public class delCommentServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取参数
        String ecid = req.getParameter("ecid");
        boolean result = false;

        Comment comment = new Comment();
        comment.setEc_id(Integer.parseInt(ecid));

        if (ecid != null) {
            CommentBiz commentBiz = new CommentBizImp();
            if (commentBiz.delComment(comment)) {
                result = true;
            }
        }

        // 根据删除结果,跳珠
        if (result) {
            req.getRequestDispatcher("manage-result.html").forward(req, resp);
        } else {
            //操作失败
            req.getRequestDispatcher("manage-result-fail.html").forward(req, resp);
        }
    }
}
