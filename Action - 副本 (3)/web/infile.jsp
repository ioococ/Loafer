<%--
  Created by IntelliJ IDEA.
  User: 荣耀
  Date: 2022/3/8
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Message</title>
    <style>
        div {
            border: 1px solid skyblue;
        }
    </style>
</head>
<body>
<div>
    <p>被嵌入的文件</p>
    <p>传值:<%out.print(request.getParameter("param"));%></p>
</div>
</body>
</html>
