package servlet;

import biz.UserBiz;
import biz.UserBizImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IDEA
 * USER:ckzippo
 * Date:9/28/16
 * TIME:5:24 PM
 */

/**
 * 用户登录Servlet
 */
public class loginServ extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 中文转码
        req.setCharacterEncoding("UTF-8");

        // 用户名密码校验
        String userName = req.getParameter("userName");
        String password = req.getParameter("passWord");

        UserBiz userBiz = new UserBizImp();
        if (userBiz.validateUser(userName, password)) {
            //校验成功
            req.getRequestDispatcher("reg-result.html").forward(req, resp);
        } else {
            //校验失败
            req.getRequestDispatcher("manage-result-fail.html").forward(req, resp);
        }
    }
}
