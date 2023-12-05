<%@ page import="static java.lang.System.out" %>
<%@ page import="java.net.InetAddress" %><%--
  Created by IntelliJ IDEA.
  User: 荣耀
  Date: 2021/11/19
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>New</title>
</head>
<body>

<%!
    private int initVar = 0;
    private int serviceVar = 0;
    private int destroyVar = 0;
%>
<%!
    public void jspInit() {
        initVar++;
        out.println("jspInit(): JSP被初始化了" + initVar + "次");
    }

    public void jspDestory() {
        destroyVar++;
        out.println("jspDestroy(): JSP被销毁了" + destroyVar + "次");
    }
%>
<%
    serviceVar++;
    System.out.println("_jspService(): JSP共响应了" + serviceVar + "次请求");
    String content1 = "初始化次数：" + initVar;
    String content2 = "响应客户端次数：" + serviceVar;
    String content3 = "销毁次数：" + destroyVar;
    String content4 = "你的本地IP为：" + request.getRemoteAddr();
    InetAddress address = InetAddress.getLocalHost();
    String content5 = "你的远程IP为：" + address.getHostAddress();
    int content6 = request.getLocalPort();

%>
<%
    out.println("<table  border=\"1\">");
    out.print("<tr>");
    out.print("<td>");
    out.print(content1);
    out.println("</td>");
    out.print("<td>");
    out.print(content2);
    out.println("</td>");
    out.print("<td>");
    out.print(content3);
    out.println("</td>");
    out.print("<td>");
    out.print(content4);
    out.println("</td>");
    out.print("<td>");
    out.print(content5);
    out.println("</td>");
    out.print("<td>");
    out.print(content6);
    out.println("</td>");
    out.println("</tr>");
    out.println("<table/>");
%>
<%--<p><%=content1%></p>--%>
<%--<p><%=content2%></p>--%>
<%--<p><%=content3%></p>--%>
<%--<p><%=content4%></p>--%>
<%--<p><%=content5%></p>--%>
<%--<p><%=content6%></p>--%>
<a href="database.jsp">test<a>
<%@include file="test.jsp" %>
</body>
</html>
