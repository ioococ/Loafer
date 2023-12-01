package manager.servlet;

import manager.dao.UserDao;
import manager.exception.UserException;
import manager.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 29/11/2023 15:22 Wednesday
 */

@WebServlet(value = "/signup", loadOnStartup = 1)
public class SignupServlet extends HttpServlet {
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
//        Enumeration<String> names = req.getParameterNames();
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        int row = 0;
        try {
            row = userService.register(username, password, email);
        } catch (UserException e) {
            resp.getWriter().println("{ \"status\": \"-1\", \"msg\": \"" + e.getMessage() + "\", \"username\": \"null\"}");
        }
        if (row != 0) {
            resp.getWriter().println("{ \"status\": \"0\", \"msg\": \"注册成功\", \"username\": \"" + username + "\"}");
            req.getSession().setAttribute("user", username);
//            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }
    }
}
