<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
  <table>
    <caption>
      <h5>登陆页面</h5>
    </caption>
    <form action="login" method="post">
      <tr>
        <td>用户名</td>
        <td><input type="text" name="uname"></td>
      </tr>
      <tr>
        <td>密码</td>
        <td><input type="password" name="pwd"></td>
      </tr>
      <tr>
        <td><button type="submit">登录</button></td>
        <td><button><a href="register.jsp">注册</a></button></td>
      </tr>
    </form>
  </table>
  <h1>${msg}</h1>
</body>
</html>
