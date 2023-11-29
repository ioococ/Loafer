<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="signup.jsp">注册</a>
<a href="login.jsp">登录</a>

<p>欢迎：<%= session.getAttribute("user") %></p>

</body>
</html>