package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sql.InitDatabase;
import sql.userTable;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AllData", value = "/AllData")
public class AllData extends HttpServlet {
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
        String rowJson = "";
        userTable ut = new userTable();
        try {
            rowJson = ut.RowJson(idb.con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.getWriter().write(rowJson);
    }
}
