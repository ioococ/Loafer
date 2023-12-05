<%@ page import="com.mysql.cj.jdbc.Driver" %>
<%@ page import="java.sql.*" %>
<%@ page import="sql.inputTable" %>
<%@ page import="sql.InitDatabase" %><%--
  Created by IntelliJ IDEA.
  User: 荣耀
  Date: 2021/11/26
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath(); //获取站点名称
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="./">
    <link rel="stylesheet" href="../css/face.css">
    <link rel="stylesheet" href="../css/total.css">
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.js"></script>
    <style>
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
    </style>
    <%!
        public void add() {

        }
    %>
    <%!
        public int pageCount(Connection con, int Rows) throws SQLException {
            Statement stmt = con.createStatement();
            String sql = "select count(*) as Rows from inputtable";
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
            String sql = "select id, bh, name, num, jhr, jsr, createdate from inputtable limit ?,?";
            Pstmt = con.prepareStatement(sql);
            Pstmt.setInt(1, (PageNum - 1) * Rows); //第一个参数是页码号
            Pstmt.setInt(2, Rows); //第二个是每页的行数
            ResultSet Rs = Pstmt.executeQuery();//返回结果集
            return Rs;
        }
    %>
</head>
<body>
<div id="app">
    <div id="card">
        <div id="divHead">入库流水</div>
        <div id="divTable">
            <%
                String name = request.getParameter("name");
                String pass = request.getParameter("password");
//                out.println("name："+name+"password："+pass);
                //指定驱动程序
                Driver DRIVER = new com.mysql.cj.jdbc.Driver();
                //指定数据库连接字符串
                String URL = "jdbc:mysql://localhost:3306/manager?characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";
                Connection con = null;

                //获取数据连接
                con = DriverManager.getConnection(URL, "root", "123456");

                String sql = "select * from inputtable";
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

                    out.print("<form>");
                    out.println("<table>");
                    rs.beforeFirst(); //记录位置跳到记录集的开始位置
                    for (int i = 1; i <= countcols + 1; i++) {
                        if (i != countcols + 1) {
                            out.print("<td>");
                            out.print(rsmd.getColumnName(i));
                            out.print("</td>");
                        }
                    }
                    rs.beforeFirst();

                    while (rs.next()) {
                        out.print("<tr " + "id='" + rs.getString("id") + "'>");
                        out.print("<td>");
                        out.print(rs.getString("id"));
                        out.println("</td>");
                        out.print("<td>");
                        out.print(rs.getString("bh"));
                        out.print("</td>");
                        out.print("<td>");
                        out.print(rs.getString("name"));
                        out.println("</td>");
                        out.print("<td>");
                        out.print(rs.getString("num"));
                        out.println("</td>");
                        out.print("<td>");
                        out.print(rs.getString("jhr"));
                        out.println("</td>");
                        out.print("<td>");
                        out.print(rs.getString("jsr"));
                        out.println("</td>");
                        out.print("<td>");
                        out.print(rs.getString("createdate"));
                        out.println("<input type='hidden' name='CurrentPage" + rs.getString("id") + "' value='" + CurrentPage + "'/>");
                        out.println("</td>");
                    }
                    out.println("</table>");
                    out.print("</form>");
                }
                out.println("<p>当前为第 " + CurrentPage + " 页，共 " + pages + " 页</p>");
                out.println("<button id='b1' class='btn' onclick='Fpage()'>上一页</button>");
                out.println("<button id='b2' class='btn' onclick='Npage()'>下一页</button>");
                out.print("<br>");
                out.print("<form action='Input.jsp' method='post'>");
//                out.print("<input type='text' name='bh' id='bh' placeholder='编号'/>");
//                out.print("<input type='text' name='name' id='name' placeholder='名称'/>");
//                out.print("<input type='text' name='num' id='num' placeholder='数量'/>");
//                out.print("<br>");
//                out.print("<input type='text' name='send' id='send' placeholder='交货人'/>");
//                out.print("<input type='text' name='receive' id='receive' placeholder='接收人'/>");
//                out.print("<br>");
//                out.println("<button type='submit' name='add' value='add'>增加</button>");
                out.print("<div class='container'>");
                out.print("<div class='row'>");
                out.print("<div class='custom-input'>");
                out.print("<input type='text' class='form-control' name='bh' id='bh' placeholder='编号'>");
                out.print("</div>");
                out.print("<div class='custom-input'>");
                out.print("<input type='text' class='form-control' name='name' id='name' placeholder='名称'>");
                out.print("</div>");
                out.print("<div class='custom-input'>");
                out.print("<input type='text' class='form-control' name='num' id='num' placeholder='数量'>");
                out.print("</div>");
                out.print("</br>");
                out.print("<div class='custom-input'>");
                out.print("<input type='text' class='form-control' name='send' id='send' placeholder='交货人'>");

                out.print("</div>");
                out.print("<div class='custom-input'>");
                out.print("<input type='text' class='form-control' name='receive' id='receive' placeholder='接收人'/>");
                out.print("</div>");
//                out.print("<div class='custom-input'>");
//                out.print("<input type='text' class='form-control' placeholder='Test 5'>");
//                out.print("</div>");
                out.print("</div>");
                out.print("</div>");
                out.println("<button type='submit' class='btn' name='add' value='add'>提交</button>");
                out.print("</form>");
                out.print("</form>");
//                rs.close();   //关闭数据集
//                stmt.close(); //关闭SQL语句执行对象
//                con.close();  //关闭连接对象
            %>
        </div>
    </div>
</div>

</body>
</html>
<Script>
    function Fpage() {
        window.location.href = 'InputUI.jsp?Fx=p&Page=<%=CurrentPage%>'
    }
</Script>
<Script>
    function Npage() {
        window.location.href = 'InputUI.jsp?Fx=n&Page=<%=CurrentPage%>'
    }
</Script>
<%--<script src="./js/since.js"></script>--%>
<script src="../js/cursor-effects.js"></script>
<script type="text/javascript" src="../js/phanimate.jquery.js"></script>