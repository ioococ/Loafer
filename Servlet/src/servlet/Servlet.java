package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "Servlet", value = "/Servlet")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应内容类型
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("当前时间："+ new Date());
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Fd");
//        requestDispatcher.forward(request,response);
        // 要重定向的新位置
        String site = new String("/Rt");

//        response.setStatus(response.SC_MOVED_TEMPORARILY);
//        response.setHeader("Location", site);

        String aa = request.getParameter("bs");
        String bb = request.getParameter("stuUsername"+aa);
        response.getWriter().write(bb);
        response.getWriter().write("<br>");
        response.getWriter().write(aa);
        System.out.println("2");

    }
    public void service(ServletRequest servletRequest, ServletResponse servletResponse, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pipedWriter=servletResponse.getWriter();
        pipedWriter.println("HelloWord!");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("3");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("1");
    }
}
