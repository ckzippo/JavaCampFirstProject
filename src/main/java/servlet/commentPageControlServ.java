package servlet;

import biz.CommentBiz;
import biz.CommentBizImp;
import entity.Comment;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created with IDEA
 * USER:ckzippo
 * Date:10/7/16
 * TIME:4:19 PM
 */
public class commentPageControlServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 中文乱码处理
        req.setCharacterEncoding("UTF-8");

        //获取所有分页用户信息
        Integer pageIndex = 1;
        if (req.getParameter("pageIndex") != null) {
            pageIndex = Integer.parseInt(req.getParameter("pageIndex"));
        }

        //默认每页显示用户数
        Integer pageSize = 10;

        //业务逻辑接口实现
        CommentBiz commentBiz = new CommentBizImp();

        //获取记录总数量
        int totalCount = commentBiz.getCommentCounts();

        // 获取总页码
        int totalPageIndex = totalCount / pageSize == 0 ? totalCount
                / pageSize : totalCount / pageSize + 1;

        HttpSession session = req.getSession();
        session.setAttribute("totalCommentPageIndex", totalPageIndex);

        //存储当前页页码，上一页，下一页
        session.setAttribute("currentCommentPageIndex", pageIndex);
        session.setAttribute("lastCommentPageIndex", pageIndex - 1);
        session.setAttribute("nextCommentPageIndex", pageIndex + 1);
        //获取分页结果集
        List<Comment> pagelst = commentBiz.getCommentsByPage(pageIndex, pageSize);
        session.setAttribute("commentlst", pagelst);

        resp.sendRedirect("gestbook.jsp");
    }
}
