package servlet;

import biz.UserBiz;
import biz.UserBizImp;
import entity.User;

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
 * Date:9/30/16
 * TIME:2:55 PM
 */

/**
 * 控制用户分页展示的Servlet。每次访问user.jsp时,先跳转到此Servlet获取分页信息
 */
public class userPageControlServ extends HttpServlet {
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
        UserBiz userBiz = new UserBizImp();

        //获取记录总数量
        int totalCount = userBiz.getUserCounts();

        // 获取总页码
        int totalPageIndex = totalCount % pageSize == 0 ? totalCount
                / pageSize : totalCount / pageSize + 1;

        HttpSession session = req.getSession();
        session.setAttribute("totalPageIndex", totalPageIndex);

        //存储当前页页码，上一页，下一页
        session.setAttribute("currentPageIndex", pageIndex);
        session.setAttribute("lastPageIndex", pageIndex - 1);
        session.setAttribute("nextPageIndex", pageIndex + 1);
        //获取分页结果集
        List<User> pagelst = userBiz.getUsersByPage(pageIndex, pageSize);
        session.setAttribute("userlst", pagelst);

        resp.sendRedirect("user.jsp");
    }
}
