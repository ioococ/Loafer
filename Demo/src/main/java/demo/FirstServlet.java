package demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;

/**
 * @Author: nekotako
 * @Description: My first servlet
 * @Date: 29/11/2023 10:41 Wednesday
 */
@WebServlet("/abc")
public class FirstServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = -2598497777295691109L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.getSession().setAttribute("msg", "success");
        PrintWriter writer = resp.getWriter();
//        writer.println("<h1>你好世界</>");
//        resp.sendRedirect("abc.jsp");
    }
}
