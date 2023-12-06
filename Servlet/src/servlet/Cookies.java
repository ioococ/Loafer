package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "Cookies", value = "/Cookies")
public class Cookies extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        OutputStream out = response.getOutputStream();

        response.setHeader("content-type", "text/html;charset=UTF-8");
        response.getWriter().write("<title>Cookie</title>");
        request.setCharacterEncoding("UTF-8");
        Cookie ck_fwcs = null;
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        Cookie[] cookies = request.getCookies(); //获取所有cookie信息
        Cookie cookie = null;
        for (int i = 0; i < cookies.length; i++) {
            String ckName = cookies[i].getName(); //获取cookie名称
            if (ckName.equals("super")) {
                cookie = cookies[i]; //取出名为super的Cookie
                cookie.setMaxAge(60 * 60 * 24 * 7);
            }
        }
        if (cookie == null) {
            response.setContentType("text/html;charset=UTF-8");
//            Cookie cookie1 = new Cookie(name,password);
//            cookie.setMaxAge(10);
            cookie.setPath("/");
            response.addCookie(cookie);
        } else {
            String str = cookie.getValue();
        }

        //定时删除
        int cs = 0;
        if (ck_fwcs == null) {
            response.setContentType("text/html;charset=UTF-8");
            Cookie cookie1 = new Cookie("fwcs", "1");
            cookie1.setMaxAge(10);
            cookie1.setPath("/");
            response.addCookie(cookie1);
            cs = 1;
        } else {
            String cs_str = ck_fwcs.getValue();
            cs = Integer.parseInt(cs_str) + 1;
            ck_fwcs.setMaxAge(10);
            ck_fwcs.setPath("/");
            ck_fwcs.setValue(Integer.toString(cs));
            response.addCookie(ck_fwcs);
        }
        String str = cookie.getValue();

        response.getWriter().write("<p> 上次保存的密码是：" + str + "</p>");
        response.getWriter().write("<p> 次数：" + cs + "</p>");
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
