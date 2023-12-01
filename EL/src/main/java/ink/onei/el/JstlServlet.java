package ink.onei.el;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 01/12/2023 15:20 Friday
 */
@WebServlet("/jstl")
public class JstlServlet extends HttpServlet {
    private static final long serialVersionUID = 2668495659415121991L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        req.getServletContext().setAttribute("list",list);
        req.getRequestDispatcher("/jstl.jsp").forward(req, resp);
    }
}
