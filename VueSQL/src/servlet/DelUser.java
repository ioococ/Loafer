package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sql.InitDatabase;
import sql.userTable;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DelUser", value = "/DelUser")
public class DelUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InitDatabase idb = new InitDatabase();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        idb.con = idb.getConnection();

        userTable ut = new userTable();
        try {
            ut.deleteUser(idb.con,username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.getWriter().write("ok");
    }
}

