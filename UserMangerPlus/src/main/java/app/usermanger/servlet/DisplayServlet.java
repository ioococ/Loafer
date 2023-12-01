package app.usermanger.servlet;

import app.usermanger.service.UserService;
import app.usermanger.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/display")
public class DisplayServlet extends HttpServlet {
    UserService us=new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");

        req.getServletContext().setAttribute("users",us.getAll());
        req.getRequestDispatcher("WEB-INF/display.jsp").forward(req,resp);
    }
}
