<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>中间页</title>
    <link rel="stylesheet" href="./styles/style.css">
    <link rel="stylesheet" href="./styles/notyf.min.css">
    <script src="https://unpkg.com/jquery@3.4.0/dist/jquery.js"></script>
    <script src="./scripts/notyf.min.js" type="text/javascript"></script>
</head>

<body>
<section class="wrapper active">
    <form class="form login" action="/login" method="post">
        <header>登录</header>
        <input type="text" id="username" name="username" placeholder="用户名" required>
        <input type="password" id="password" name="password" placeholder="密码" required>
        <div class="captcha">
            <input type="text" id="captcha" name="captcha" placeholder="验证码" required>
            <img onclick="refresh()" id="captchaImg" src="getCaptcha" alt="" width="150px" height="50px"></div>
        <div><a href="#">忘记密码</a> <span style="color: red;">${requestScope.msg}</span></div>
        <button class="btn">登录</button>
    </form>
</section>
</body>
<script>
    let img = document.getElementById("captchaImg");

    function refresh() {
        let timestamp = new Date().getTime();
        img.setAttribute("src", "getCaptcha?time=" + timestamp);
    }
</script>
<%request.removeAttribute("msg");%>
</html>