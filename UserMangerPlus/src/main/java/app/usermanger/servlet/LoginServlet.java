package app.usermanger.servlet;

import app.usermanger.entity.User;
import app.usermanger.service.UserService;
import app.usermanger.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    UserService us = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");

        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");

        User user = us.getUserByName(uname);
        if (user != null) {
//            存在用户名
            if (user.getPwd().equals(pwd)) {
//                密码正确，登录成功
                req.getServletContext().setAttribute("msg", "登录成功");
                req.getRequestDispatcher("display").forward(req, resp);
            } else {
//                密码错误
                req.getServletContext().setAttribute("msg", "登录失败,密码错误");
            }
        } else {
            req.getServletContext().setAttribute("msg", "用户名不存在");
        }
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }
}
