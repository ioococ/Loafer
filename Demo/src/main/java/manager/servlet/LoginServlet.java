package manager.servlet;

import manager.dao.UserDao;
import manager.entity.User;
import manager.exception.UserException;
import manager.service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 29/11/2023 17:22 Wednesday
 */

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    UserService userService = null;
    UserDao userDao = null;

    @Override
    public void init() {
        userService = new UserService();
        userDao = new UserDao();
    }

    @Serial
    private static final long serialVersionUID = 4500135802590566561L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        Enumeration<String> names = req.getParameterNames();
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = null;
        try {
            System.out.println(username);
            user = userService.login(username, password);
        } catch (UserException e) {
            resp.getWriter().println("{ \"status\": \"-1\", \"msg\": \"" + e.getMessage() + "\", \"username\": \"null\"}");
        }
        if (user != null) {
            req.getSession().setAttribute("user", username);
            resp.getWriter().println("{ \"status\": \"0\", \"msg\": \"登录成功\", \"username\": \"" + username + "\"}");
        }
    }
}
