package app.goodsmanager.servlet;

import app.goodsmanager.service.IUserService;
import app.goodsmanager.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;

@WebServlet("/center")
public class CenterServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 2193320400498892924L;
    IUserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") == null) {
            resp.sendRedirect("/login.jsp");
            return;
        }

        req.getRequestDispatcher("/WEB-INF/center.jsp").forward(req, resp);

    }
}
