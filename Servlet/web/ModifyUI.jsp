<%@ page import="sql.InitDatabase" %>
<%@ page import="sql.userTable" %><%--
  Created by IntelliJ IDEA.
  User: 荣耀
  Date: 2021/12/1
  Time: 8:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改</title>
    <link rel="shortcut icon"href="favicon.ico">
    <link rel="stylesheet" href="./css/style.css">
    <link rel="stylesheet" type="text/css" href="./css/notyf.min.css">
    <script src="./js/notyf.min.js" type="text/javascript"></script>
    <style>
        #user {
            margin: 0 auto;
            height: auto;
            width: 500px;
        }

        .inputBox {
            color: rgba(255, 255, 255, 0.9);
        }

        .reset {
            height: 43px !important;
            width: 100px !important;
        }
    </style>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
    String bb = request.getParameter("modify"); //取按钮的ID
    String aa = request.getParameter("stuUsername" + bb);//取要删除的用户名
%>
<section>
    <div class="color"></div>
    <div class="color"></div>
    <div class="color"></div>
    <div class="box">
        <div class="circle" style="--x:0"></div>
        <div class="circle" style="--x:1"></div>
        <div class="circle" style="--x:2"></div>
        <div class="circle" style="--x:3"></div>
        <div class="circle" style="--x:4"></div>
        <div class="container">
            <div class="form" id="user">
                <h2>修改</h2>
                <form onsubmit="return check()" method="post">
                    <table>
                        <div class="inputBox">用户名：<input type="hidden" name="userName" id="userName" value="<%=aa%>">
                            <span><%=aa%></span>
                        </div>
                        <div class="inputBox"><input type="password" name="pw1" id="pw1" placeholder="密码" value="">
                        </div>
                        <div class="inputBox"><input type="password" name="pw2" id="pw2" placeholder="密码" value="">
                        </div>
                        <div class="inputBox">
                            <input type="submit" name="b1" value="确定"/>
                            <input class="reset" type="reset" name="b2" value="重置"/>
                        </div>
                    </table>
                </form>
            </div>
        </div>
    </div>
</section>
</body>
</html>
<script type="text/javascript">
    function check() {
        var notyf = new Notyf({delay: 3000});
        var uName = document.getElementById("userName").value;
        var pW1 = document.getElementById("pw1").value;
        var pW2 = document.getElementById("pw2").value;
        if (uName === "" || uName === "null") {
            notyf.alert("操作失败");
            return false;
        } else {
            if (pW1 === pW2) {
                notyf.confirm("操作成功");
                <%Thread.sleep(3500);%>
                return true;

            } else {
                notyf.alert("操作失败");
                <%Thread.sleep(3500);%>
                return false;
            }
        }
    }
</script>
<script src="https://cdn.bootcdn.net/ajax/libs/jquery.pjax/2.0.1/jquery.pjax.js"></script>
<%
    InitDatabase idb = new InitDatabase();//创建数据库初始化对象
    idb.con = idb.getConnection();//获取数据库连接
    idb.CrateTable();//切换数据库
    userTable ut = new userTable();//创建用户表操作对象
    ut.Modifypwd(idb.con, bb, aa);
    idb.closeAll(idb.con); //关闭数据库连接，交回连接池
//    response.sendRedirect("./database.jsp");
%>
