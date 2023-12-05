<%@ page import="jakarta.servlet.http.HttpSession" %><%--
  Created by IntelliJ IDEA.
  User: szkj
  Date: 2021-12-08
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="http://localhost:8080/kcM/">
</head>
<body>
        <%
            HttpSession Session=request.getSession();
            Session.invalidate(); //删除本次会话的Session
        %>
        <script>
            window.open("Login.html","_top");
        </script>
</body>
</html>
