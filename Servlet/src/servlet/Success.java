package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "Success", value = "/Success")
public class Success extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String name = session.getAttribute("username1").toString();
        String password = session.getAttribute("password1").toString();
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(name+"登录成功"+password);
    }
}
