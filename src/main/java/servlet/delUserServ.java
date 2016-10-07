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
 * Date:10/7/16
 * TIME:9:13 AM
 */
public class delUserServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //中文乱码处理
        req.setCharacterEncoding("UTF-8");

        //获取参数
        String userid = req.getParameter("id");

        boolean result = false;

        if (userid != null) { //如果参数不为空
            //填充ID字段
            User user = new User();
            user.setEu_user_id(Integer.valueOf(userid));

            //删除用户
            UserBiz userBiz = new UserBizImp();
            if (userBiz.delUser(user)) {
                result = true;
            } else {
                result =false;
            }

        } else {
            result = false;
        }

        if (result) {
            req.getRequestDispatcher("manage-result.html").forward(req, resp);
        } else {
            //操作失败
            req.getRequestDispatcher("manage-result-fail.html").forward(req, resp);
        }

    }
}
