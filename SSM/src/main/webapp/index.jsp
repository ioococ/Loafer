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
    if (session.getAttribute("user") == null) {
        out.println("<p>请先登录</p>");
    } else {
        out.println("<p>欢迎：" + session.getAttribute("user") + " <i style=\"color:red;\" onclick=\"logout()\">注销</i> </p>");
    }
%>
<a href="signup.jsp">注册</a>
<a href="signin.jsp">登录</a>
</body>
<script>
    function logout() {
        <%session.removeAttribute("user");%>
        location.reload();
    }
</script>
</html>