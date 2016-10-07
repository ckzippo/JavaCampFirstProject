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
 * TIME:9:53 PM
 */

/**
 * 修改用户留言
 */
public class modCommentServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 中文转码
        req.setCharacterEncoding("UTF-8");

        // 获取请求参数
        String orderId = req.getParameter("orderId");
        String name = req.getParameter("name");
        String content = req.getParameter("content");
        String replyContent = req.getParameter("replyContent");

        CommentBiz commentBiz = new CommentBizImp();
        Comment comment = commentBiz.getCommentById(Integer.parseInt(orderId));

        if (name != null) {
            comment.setEc_nick_name(name);
        }
        if (content != null) {
            comment.setEc_content(content);
        }
        if (replyContent != null) {
            comment.setEc_reply(replyContent);
        }

        if (commentBiz.modComment(comment)) {
            System.out.println("修改成功");
            req.getRequestDispatcher("manage-result.html").forward(req, resp);
        } else {
            System.out.println("修改失败");
            req.getRequestDispatcher("manage-result-fail.html").forward(req, resp);
        }

    }
}
