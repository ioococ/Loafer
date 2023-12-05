<%@ page import="sql.*" %>
<%--
  Created by IntelliJ IDEA.
  User: 荣耀
  Date: 2021/12/1
  Time: 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
    String bb = request.getParameter("userName");
    String aa = request.getParameter("pw1");

    InitDatabase idb = new InitDatabase();//创建数据库初始化对象
    idb.con = idb.getConnection();//获取数据库连接
    idb.CrateTable();//切换数据库
    userTable ut = new userTable();//创建用户表操作对象
    ut.addUser(idb.con,bb,aa,"super");
    idb.closeAll(idb.con); //关闭数据库连接，交回连接池
    out.print("添加成功");
%>

</body>
</html>
