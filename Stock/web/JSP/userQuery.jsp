<%@ page import="com.mysql.cj.jdbc.Driver" %>
<%@ page import="java.sql.*" %>
<%@ page import="jakarta.servlet.jsp.PageContext" %><%--
  Created by IntelliJ IDEA.
  User: 荣耀
  Date: 2021/11/26
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath(); //获取站点名称
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/JSP/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="../css/face.css">
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.js"></script>
    <style>
        /*html, body {*/
        /*    margin: 0;*/
        /*    padding: 0;*/
        /*    background: ghostwhite;*/
        /*    cursor: url("../src/cursor.ico"), pointer;*/
        /*    width: 100%;*/
        /*    height: 100%;*/
        /*}*/

        ::selection {
            background: #E7E7FF;
        }

        table {
            width: 90%;
            padding: 2px;
            border: none;
            /*边框颜色*/
            background: #C3C3FF;
            /*字体颜色*/
            color: #C3C3FF;
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
            margin: auto;
            height: auto;
            /*border: 10px solid ghostwhite;*/
            color: #C3C3FF;
            text-align: center;
            padding: 15px;
            border-radius: 10px;
        }

        #divHead {
            font-weight: bold;
            font-size: 30px;
        }

        button {
            border: 1px solid #c3c3ff;
            background: #F8F8FF;
            color: #ceceff;
        }

        button:hover {
            background: #E0E0FF;
            transition: .15s;
        }

    </style>
    <%!
        public int pageCount(Connection con, int Rows) throws SQLException {
            Statement stmt = con.createStatement();
            String sql = "select count(*) as Rows from usertable";
            ResultSet rs = stmt.executeQuery(sql);
            int pages = 0;
            rs.next();
            if (rs != null) {
                pages = (int) Math.ceil((double) rs.getInt("Rows") / (double) Rows);
            }
            return pages;
        }
    %>
    <%!
        //分页显示的方法 PageNum为要显示的页码 Rows每页显示的记录条数
        public ResultSet PageShow(Connection con, int PageNum, int Rows) throws SQLException {
            PreparedStatement Pstmt = null;
            String sql = "select id,username,createuser,createdate from userTable limit ?,?";
            Pstmt = con.prepareStatement(sql);
            Pstmt.setInt(1, (PageNum - 1) * Rows); //第一个参数是页码号
            Pstmt.setInt(2, Rows); //第二个是每页的行数
            ResultSet Rs = Pstmt.executeQuery();//返回结果集
            return Rs;
        }
    %>
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
<div id="app">
    <div id="card">
        <div id="divHead">用户查询</div>
        <div id="divTable">
            <%
                //指定驱动程序
                Driver DRIVER = new com.mysql.cj.jdbc.Driver();
                //指定数据库连接字符串
                String URL = "jdbc:mysql://localhost:3306/manager?characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";
                Connection con = null;

                //获取数据连接
                con = DriverManager.getConnection(URL, "root", "123456");

                String sql = "select id,username,createuser,createdate from usertable";
                Statement stmt = con.createStatement();


                String pageId = request.getParameter("Page");//接收当前页
                if (pageId == null) {
                    pageId = "1";
                }
                String Fx = request.getParameter("Fx"); // 上一页按钮 还是下一页按钮

                int Rows = 6; //每页显示六条
                int pages = pageCount(con, Rows); // 每页显示的记录条数
                int CurrentPage = 0;

                if (Fx != null) {
                    if (Fx.equals("p")) { //说明点的是上一页按钮
                        CurrentPage = Integer.parseInt(pageId) - 1; //现在要显示的页码为之前页码-1
                        if (CurrentPage == 0) { //如果是0 说明到头了 那前页就是第一页
                            CurrentPage = 1;
                        }
                    } else if (Fx.equals("n")) {
                        CurrentPage = Integer.parseInt(pageId) + 1; //现在要显示的页码为之前页码+1
                        if (CurrentPage > pages) {
                            CurrentPage = pages;
                        }
                    } else { //既没有按上一页 也没有按下一页
                        CurrentPage = Integer.parseInt(pageId);
                    }
                } else { //那里都没有点过 就是第一页
                    CurrentPage = 1;
                }
                ResultSet rs = PageShow(con, CurrentPage, Rows);//第一个参数为链接 第二个为页码 第三个为每页显示的记录数
                if (rs != null) {
                    //7.取元数据(字段名)以制表符为间隔显示出来
                    ResultSetMetaData rsmd = rs.getMetaData();//获取字段名字
                    int countcols = rsmd.getColumnCount(); //获取字段数量

                    out.print("<form method='post'>");
                    out.println("<table>");
                    for (int i = 1; i <= countcols; i++) {
                        out.print("\t");
                        out.print("<td class='header'>");
                        out.print(rsmd.getColumnName(i));
                        out.println("</td>");
                    }
                    out.print("<td class='header'>");
                    out.print("操作");
                    out.println("</td>");
                    rs.beforeFirst();
                    while (rs.next()) {
                        out.print("<tr " + "id='" + rs.getString("ID") + "'>");
                        out.print("<td>");
                        out.print(rs.getString("ID"));
                        out.println("</td>");
                        out.print("<td>");
                        out.print("<input type='hidden' " + "name='stuNam" + rs.getString("id") + "' value='" + rs.getString("id") + "'/>");
                        out.println("</td>");
                        //out.print("<td>");
                        //out.print(rs.getString("password"));
                        //out.print("</td>");
                        out.print("<td>");
                        out.print(rs.getString("createuser"));
                        out.println("</td>");
                        out.print("<td>");
                        out.print(rs.getString("createdate"));
                        out.println("</td>");
                        out.print("<td>");
                        out.println("<input type='hidden' name='CurrentPage" + rs.getString("id") + "' value='" + CurrentPage + "'/>");
                        out.println("<button type='submit' name='modify' value='" + rs.getString("id") + "' onclick=\"form.action='ModifyUI.jsp'\";form.submit();>修改</button>");
                        out.println("<button type='submit' name='bb' value='" + rs.getString("id") + "' onclick=form.submit();>删除</button>");
                        out.println("<button type='submit' name='bs' value='" + rs.getString("id") + "' onclick=\"form.action='OK'\">Servlet</button>");
                        //out.print("<button type='submit' name='bb' value='" + rs.getString("id") + "' onclick='notyf()'; >删除</button>");

                        out.println("</td>");
                        out.println("</tr>");
                    }
                    out.println("</table>");
                    out.print("</form>");
                }
                out.println("<p>当前为第" + CurrentPage + "页，共计：" + pages + "页</p>");
                out.println("<button id='b1' onclick='Fpage()'>上一页</button>");
                out.println("<button id='b2' onclick='Npage()'>下一页</button>");
                out.println("<button type='submit' name='add' value='add' onclick=\"form.action='ModifyUI.jsp'\";form.submit();>增加</button>");
            %>

        </div>
    </div>
</div>

</body>
</html>
<%
    String bb = request.getParameter("bb"); //取按钮的ID
    String aa = request.getParameter("stuUsername" + bb);//取要删除的用户名

    sql = "select*from usertable";
    rs = stmt.executeQuery(sql);
    deleteUser(con, aa);

%>
<script>
    function notyf() {
        var notyf = new Notyf({delay: 3000});
        notyf.confirm("操作成功");
        form.submit();
    }
</script>
<Script>
    function Fpage() {
        window.location.href = 'userQuery.jsp?Fx=p&Page=<%=CurrentPage%>'
    }
</Script>
<Script>
    function Npage() {
        window.location.href = 'userQuery.jsp?Fx=n&Page=<%=CurrentPage%>'
    }
</Script>
<script src="../js/since.js"></script>
<script src="../js/cursor-effects.js"></script>

