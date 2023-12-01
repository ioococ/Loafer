<%@ page import="java.util.List" %>
<%@ page import="app.usermanger.entity.User" %><%--
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>展示所有用户信息页面</title>
</head>
<body>
<table>
        <tr>
            <td>id</td>
            <td>用户名</td>
        </tr>
    <%
        List<User> users= (List<User>) request.getServletContext().getAttribute("users");
        for (User user: users
             ) {
    %>
        <tr>
            <td><%= user.getId()%></td>
            <td><%= user.getName()%></td>
        </tr>
    <%

        }%>
</table>
</body>
</html>
