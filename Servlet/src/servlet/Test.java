package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.OutputStream;

@WebServlet(name = "Test")
public class Test extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");//指定字符集
        String name=request.getParameter("name");//获取网页传过来的用户名
        String p1=request.getParameter("p1");//获取网页传过来的密码
        Cookie[] cookies=request.getCookies();//获取浏览器端传过来的所有cookie信息
        Cookie ck=null;
        Cookie ck_fwcs=null;//客户端的访问次数
        for (int i=0;i<cookies.length;i++){
            String cookieName=cookies[i].getName();//获取cookies的名称
            if (cookieName.equals("zhang")){
                ck=cookies[i];//取出名为zhang的cookie
            }
            if (cookieName.equals("fwcs")){
                ck_fwcs=cookies[i];
            }
        }
        String str="";
        if (ck==null){
//            response.setContentType("text/html;charset=UTF-8");
            Cookie cookie=new Cookie(name,p1);
            cookie.setMaxAge(10*60);//保存十分钟
            cookie.setPath("/");//设置当前站点下所以的网页都可以访问此cookie
            response.addCookie(cookie);//存到本地 0
        }else {
            str=ck.getValue();//取出指定cookie里的数据
        }

        int cs=0;
        if (ck_fwcs==null){
//            response.setContentType("text/html;charset=UTF-8");
            Cookie cookie=new Cookie("fwcs","1");
            cookie.setMaxAge(10);//设置有效期为10秒
            cookie.setPath("/");//当前网站下的所有网页都可以访问此cookie
            response.addCookie(cookie);//添加cookie到浏览器
            cs=1;
        }else {//找到了，说明已经访问过了，取出次数，然后加1次
            String cs_str=ck_fwcs.getValue();//取出cookie的数值
            cs=Integer.parseInt(cs_str)+1;
            ck_fwcs.setMaxAge(10);
            ck_fwcs.setPath("/");
            ck_fwcs.setValue(Integer.toString(cs));//修改值
            response.addCookie(ck_fwcs);//修改cookie到浏览器
        }

//        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("<H1>上次保存的密码是:"+str+"</H1>");//将取出的密码显示在网页上
        response.getWriter().write("<H1>浏览器十秒内访问的次数:"+cs+"</H1>");//将浏览器访问的次数显示在网页上




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
