package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "Session", value = "/Session")
public class Session extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        HttpSession session = request.getSession(); //从服务器获取session
        session.setAttribute("username",name);//将用户名存入Session username属性中
        session.setAttribute("password",password);//将密码存入Session password属性中

        if (name.trim().equals("Super")&& password.trim().equals("Super")){
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write("成功");
            response.sendRedirect("Ss");
        } else {
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write("失败");
            response.sendRedirect("Er");
        }
    }
}
