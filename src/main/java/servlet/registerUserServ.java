package servlet;

import biz.UserBiz;
import biz.UserBizImp;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IDEA
 * USER:ckzippo
 * Date:9/28/16
 * TIME:4:55 PM
 */

/**
 * 注册用户Servlet
 */
public class registerUserServ extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 防止中文乱码
        req.setCharacterEncoding("UTF-8");

        // 获取参数
        String userName = req.getParameter("userName");
        String password = req.getParameter("passWord");

        User user = new User();
        user.setEu_user_name(userName);
        user.setEu_password(password);

        // 调用接口在数据库中新增用户
        UserBiz userBiz = new UserBizImp();
        if (userBiz.addUser(user)) {
            //新增成功
            req.getRequestDispatcher("reg-result.html").forward(req, resp);
        } else {
            // 新增失败
            req.getRequestDispatcher("manage-result-fail.html").forward(req, resp);
        }
    }
}
