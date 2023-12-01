package app.usermanager.servlet;

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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = -2305190609818809993L;
    IUserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    /**
     * 登录功能
     * <p>
     * 首先进行用户判断 如果用户不存在 则返回异常信息
     * <p>
     * 否则进行添加 并返回info页面
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (userService.getUserByName(username) == null) {
            req.setAttribute("msg", "用户不存在");
            return;
        }
        try {
            userService.login(username, password);
        } catch (UserException e) {
            req.setAttribute("msg", e.getMessage());
        }
        req.getSession().setAttribute("user", username);
        resp.sendRedirect("info");
    }
}
