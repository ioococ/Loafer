package app.usermanager.servlet;

import app.usermanager.entity.User;
import app.usermanager.exception.UserException;
import app.usermanager.service.IUserService;
import app.usermanager.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;

/**
 * 注册功能
 * <p>
 * 如果用户已存在 返回异常
 * <p>
 * 否则进行添加
 */
@WebServlet(value = "/signup")
public class SignupServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = -6240648232378265491L;
    IUserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try {
            userService.signup(new User(username, password));
        } catch (UserException e) {
            req.setAttribute("msg", e.getMessage());
        }
        req.getSession().setAttribute("msg", "注册成功");
        req.getSession().setAttribute("user", username);
        resp.sendRedirect("index.jsp");
    }
}
