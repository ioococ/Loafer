<%@ page import="com.mysql.cj.jdbc.Driver" %>
<%@ page import="java.sql.*" %><%--
  Created by IntelliJ IDEA.
  User: 荣耀
  Date: 2021/11/26
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HTML与JSP混写</title>
    <link rel="stylesheet" href="./css/face.css">
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.js"></script>
    <style>
        html, body {
            margin: 0;
            padding: 0;
            background: ghostwhite;
            cursor: url("./src/cursor.ico"), pointer;
            width: 100%;
            height: 100%;
        }
        canvas{
            height: 100%;
        }
        ::selection {
            background: #E7E7FF;
        }

        table {
            width: 90%;
            padding: 2px;
            border: none;
            /*边框颜色*/
            background: #c3c3ff;
            /*字体颜色*/
            color: #c3c3ff;
            margin: 10px auto;
            /*border-collapse: collapse;!*border-collapse:collapse合并内外边距(去除表格单元格默认的2个像素内外边距*!*/
            border-radius: 3px;
        }

        td > button {
            margin: 3px;
            height: 20px;
        }

        th, td {
            border: none;
            height: 25px;
            line-height: 25px;
            text-align: center;
        }

        th {
            /*background: #FBF8C2;*/
            font-weight: normal;
        }

        tr {
            border: none;
            /*背景底色*/
            background: #F8F8FF;
            transition: .5s;
        }

        tr:hover {
            /*选中底色*/
            background: #e7e7ff;
            transition: .5s;
        }

        td a {
            color: rgb(0, 0, 0);
            text-decoration: none;
        }

        td a:hover {
            color: rgb(0, 0, 0);
            text-decoration: underline;
            transition: .5s;
        }

        #divTable, #divHead {
            /*float: left;*/
            margin: auto;
            height: auto;
            width: 70%;
            /*border: 10px solid ghostwhite;*/
            color: #C3C3FF;
            text-align: center;
            padding: 30px;
            border-radius: 10px;
        }

        #divHead {
            font-size: 30px;
        }

        .header {
            font-weight: bold;
            text-transform: uppercase;
        }

        .button, button {
            border: 1px solid #c3c3ff;
            background: #F8F8FF;
            color: #ceceff;
        }

        .button:hover, button:hover {
            background: #E0E0FF;
            transition: .15s;
        }

        .button {
            padding: 5px;
            font-size: 20px;
            height: 35px;
        }

        footer {
            margin: 0 auto;
            padding-top: 5px;
            background: rgba(231,231,255,0.5);
            /*backdrop-filter: opacity(30%);*/
            height: 70px;
            width: 100%;
            position: absolute;
            bottom: 0;
            backdrop-filter: blur(5px)
        }

        footer > div {
            margin: 0 auto;
            height: fit-content;
            width: fit-content;
            box-sizing: content-box;
        }

        .variable {
            margin: auto;
            height: fit-content;
            width: fit-content;
        }

        .variable > span {
            text-align: center;
            font-size: 13px;
            color: #C3C3FF !important;
        }

        .jsp {
            display: inline;
        }
    </style>
    <%!
        public int deleteUser(Connection con, String userName) throws SQLException {
            PreparedStatement Pstmt = null;
            String sql = "delete from userTable where username=?";
            Pstmt = con.prepareStatement(sql);
            Pstmt.setString(1, userName);
            int num = Pstmt.executeUpdate();
            return num;
        }
    %>
</head>
<body>
<div id="app" style="width: 100%;height: 100%;">
    <div id="card">
        <%--<div id="app" style="width: 100%;height: 100%;">--%>
        <div id="divHead">
            MySQL用户数据
        </div>
        <div id="divTable">
<%--            <%--%>
<%--                //指定驱动程序--%>
<%--                Driver DRIVER = new com.mysql.cj.jdbc.Driver();--%>
<%--                //指定数据库连接字符串--%>
<%--                String URL = "jdbc:mysql://localhost:3306/manager?characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";--%>
<%--                Connection con = null;--%>
<%--                String sql = "select*from usertable";--%>
<%--                //获取数据连接--%>
<%--                con = DriverManager.getConnection(URL, "root", "123456");--%>
<%--                Statement stmt = con.createStatement();--%>
<%--                ResultSet rs = stmt.executeQuery(sql);--%>
<%--                ResultSetMetaData rsmd = rs.getMetaData();--%>
<%--                int countcols = rsmd.getColumnCount();--%>

<%--                out.print("<form method='post'>");--%>
<%--                out.print("<table>");--%>
<%--                for (int i = 1; i <= countcols; i++) {--%>
<%--                    if (i > 1) out.print("\t");--%>
<%--                    out.print("<td class=\"header\">");--%>
<%--                    out.print(rsmd.getColumnName(i));--%>
<%--                    out.print("</td>");--%>
<%--                }--%>
<%--                out.print("<td class='header'>");--%>
<%--                out.print("操作");--%>
<%--                out.print("</td>");--%>
<%--                rs.beforeFirst();--%>
<%--                while (rs.next()) {--%>
<%--                    out.print("<tr " + "id='" + rs.getString("ID") + "'>");--%>
<%--                    out.print("<td>");--%>
<%--                    out.print(rs.getString("ID"));--%>
<%--                    out.print("</td>");--%>
<%--                    out.print("<td>");--%>
<%--                    out.print(rs.getString("username"));--%>
<%--                    out.print("<input type='hidden'" + "name='stuUsername" + rs.getString("id") + "' value='" + rs.getString("username") + "' />");--%>
<%--                    out.print("</td>");--%>
<%--                    out.print("<td>");--%>
<%--                    out.print(rs.getString("password"));--%>
<%--                    out.print("</td>");--%>
<%--                    out.print("<td>");--%>
<%--                    out.print(rs.getString("createuser"));--%>
<%--                    out.print("</td>");--%>
<%--                    out.print("<td>");--%>
<%--                    out.print(rs.getString("createdate"));--%>
<%--                    out.print("</td>");--%>
<%--                    out.print("<td>");--%>
<%--                    out.print("<button type='submit' name='modify' value='" + rs.getString("id") + "' onclick=\"form.action='ModifyUI.jsp'\";form.submit();'" + "' >修改</button>");--%>
<%--                    out.print("<button type='submit' name='bb' value='" + rs.getString("id") + "' onclick=form.submit();'" + "' >删除</button>");--%>
<%--                    out.print("<button type='submit' name='bs' value='" + rs.getString("id") + "' onclick=\"form.action='OK'\">Servlet</button>");--%>
<%--//                out.print("<button type='submit' name='bb' value='" + rs.getString("id") + "' onclick='notyf()'; >删除</button>");--%>

<%--                    out.print("</td>");--%>
<%--                    out.print("</tr>");--%>
<%--                }--%>
<%--                out.println("</table>");--%>
<%--                out.print("</form>");--%>
<%--                out.println("完成");--%>
<%--            %>--%>
        </div>
    </div>
</div>
<footer>
    <div class="footer">
        <form class="jsp" action="Cs" method="post">
            <input type="hidden" name="name" value="Super">
            <input type="hidden" name="password" value="Super">
            <input class="button" type="submit" value="Cookie"/>
        </form>
        <form class="jsp" action="Sn" method="post">
            <input type="hidden" name="name" value="Super">
            <input type="hidden" name="password" value="Super">
            <input class="button" type="submit" value="Session"/>
        </form>
        <form class="jsp" action="UserOnline.jsp" method="post">
            <input class="button" type="submit" value="当前在线人数"/>
        </form>
        <div class="variable">
            <span id="since"></span><span class="my-face">(●'◡'●)ﾉ♥</span>
        </div>
    </div>
</footer>

</body>
</html>
<%--<%--%>
<%--    String bb = request.getParameter("bb"); //取按钮的ID--%>
<%--    String aa = request.getParameter("stuUsername" + bb);//取要删除的用户名--%>

<%--    sql = "select*from usertable";--%>
<%--    rs = stmt.executeQuery(sql);--%>
<%--    deleteUser(con, aa);--%>

<%--%>--%>
<script>
    function notyf() {
        var notyf = new Notyf({delay: 3000});
        notyf.confirm("操作成功");
        form.submit();
    }
</script>
<script src="./js/since.js"></script>
<script src="./js/cursor-effects.js"></script>
<script src="https://cdn.jsdelivr.net/npm/janvas"></script>
<
