<%@ page import="com.mysql.cj.jdbc.Driver" %>
<%@ page import="java.sql.*" %><%--
  Created by IntelliJ IDEA.
  User: 荣耀
  Date: 2021/11/30
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete</title>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme()+":"+request.getServletPath()+":"+request.getServerPort()+"/";%>
</head>
<body>
<div>
    <%!
        public int deleteUser(Connection con,String userName) throws SQLException {
            PreparedStatement Pstmt = null;
            String sql = "delete from userTable where username=?";
            Pstmt = con.prepareStatement(sql);
            Pstmt.setString(1,userName);
            int num = Pstmt.executeUpdate();
            return num;
        }
    %>
    <%
        String bb = request.getParameter("bb"); //取按钮的ID
        String aa = request.getParameter("stuUsername"+bb);//取要删除的用户名
    %>
    <%
        //指定驱动程序
        Driver DRIVER = new com.mysql.cj.jdbc.Driver();
        //指定数据库连接字符串
        String URL = "jdbc:mysql://localhost:3306/manager?characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";
        Connection con = null;
        String sql = "select*from usertable";
        //获取数据连接
        con = DriverManager.getConnection(URL, "root", "123456");
        out.println("数据库连接成功");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        try {
            deleteUser(con,aa);
            out.print("<p>用户名："+aa+"删除成功<p>");
        } catch (SQLException e){
            out.print("<p>用户名："+aa+"删除失败<p>");
            e.printStackTrace();
        }

    %>
    <br>
    <a href="database.jsp">返回上一页</a>
    <br>
</div>
</body>
</html>
<script>
    // window.location.href="database.jsp";
    <%
    response.sendRedirect("database.jsp");
    %>
</script>
