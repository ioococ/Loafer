<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
<table>
    <caption>
        <h5>注册页面</h5>
    </caption>
    <form action="register" method="post">
        <tr>
            <td>用户名</td>
            <td><input type="text" name="uname"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="pwd"></td>
        </tr>
        <tr>
            <td><button type="submit">注册</button></td>
            <td><button><a href="login.jsp">登录</a></button></td>
        </tr>
    </form>
</table>

<h1>${msg}</h1>
</body>
</html>
