package app.usermanager.servlet;

import app.usermanager.service.IUserService;
import app.usermanager.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;

@WebServlet("/info")
public class ListServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 2193320400498892924L;
    IUserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");

        req.getSession().setAttribute("users", userService.getAllUsers());
        req.getRequestDispatcher("WEB-INF/info.jsp").forward(req, resp);

    }
}
