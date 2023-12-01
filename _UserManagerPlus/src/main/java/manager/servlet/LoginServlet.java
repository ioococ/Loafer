package manager.servlet;

import manager.dao.UserDao;
import manager.entity.User;
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
 * @Date: 29/11/2023 17:22 Wednesday
 */

@WebServlet(value = "/login", loadOnStartup = 1)
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        Enumeration<String> names = req.getParameterNames();
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String type = request.getHeader("X-Requested-With");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = null;
        try {
            user = userService.login(username, password);
        } catch (UserException e) {
            response.getWriter().println("{ \"status\": \"-1\", \"msg\": \"" + e.getMessage() + "\", \"username\": \"null\"}");
        }
        if (user != null) {
            request.getSession().setAttribute("user", username);
//            response.getWriter().println("{ \"status\": \"0\", \"msg\": \"登录成功\", \"username\": \"" + username + "\"}");
            response.setContentType("text/html;charset=utf-8");
            response.addHeader("type", "document");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}
