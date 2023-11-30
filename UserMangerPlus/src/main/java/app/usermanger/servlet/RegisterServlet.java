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

@WebServlet(value = "/register")
public class RegisterServlet extends HttpServlet {
    UserService us = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");

        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");

        User user = us.getUserByName(uname);
        if (user == null) {
//            不存在用户名，可以进行注册
            if (us.register(new User(uname, pwd))) {
                req.getServletContext().setAttribute("msg", "注册成功");
            } else {
                req.getServletContext().setAttribute("msg", "注册失败，请重试");
            }
        } else {
//            存在这个用户名
            req.getServletContext().setAttribute("msg", "用户名已存在");
        }
        req.getRequestDispatcher("register.jsp").forward(req, resp);
    }
}
