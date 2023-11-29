package webapp.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;

@WebServlet("/hello")
//@WebServlet(name = "helloServlet", value = "/hello")
public class HelloServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 8193544692365480506L;
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 设置返回值类型
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<p>你好，世界</p>");
        out.println("</body></html>");
        request.getSession().setAttribute("msg", "success");
        response.sendRedirect("index.jsp");
    }

    public void destroy() {
    }
}