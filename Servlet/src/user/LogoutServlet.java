package user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "LogoutServlet")
public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//设置响应内容类型
        //request.setCharacterEncoding("utf-8");
        //销毁会话，会触发SessionLinstener中的sessionDestroyed方法
        request.getSession().invalidate();
        //从应用上下文中获取在线用户名列表
        List<String> online = (List<String>)getServletContext().getAttribute("online");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>用户列表</title></head>");
        out.println("<body>");
        out.print("<h3>在线用户列表</h3>");
        int size = ((online == null) ? 0 : online.size());
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                out.println("<br />");
            }
            out.println(i + 1 + "." + online.get(i));
        }
        out.println("<hr><a href=\"UserOnline.jsp\">主页</hr>");
        out.println("</body>");
        out.println("</html>");
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       this.doPost(request,response);
    }
}
