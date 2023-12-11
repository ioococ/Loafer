<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<%

    out.println(session.getAttribute("user") + " 欢迎来到个人中心</p>");

%>
<a href="goods">
    <button>商品信息</button>
</a>
</body>
</html>