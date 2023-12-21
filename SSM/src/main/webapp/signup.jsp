<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>中间页</title>
    <link rel="stylesheet" href="./styles/style.css">
    <link rel="stylesheet" href="./styles/notyf.css">
    <script src="https://unpkg.com/jquery@3.4.0/dist/jquery.js"></script>
    <script src="./scripts/notyf.js" type="text/javascript"></script>
</head>

<body>
<section class="wrapper">
    <form class="form signup" action="/signup" method="post">
        <header>注册</header>
        <input type="text" id="username" name="username" placeholder="用户名" required>
        <input type="email" id="email" name="email" placeholder="电子邮件">
        <input type="password" id="password" name="password" placeholder="密码" required>
        <div class="checkbox">
            <input type="checkbox" id="check">
            <label for="check">我接受用户条款</label>
        </div>
        <button class="btn">注册</button>
    </form>
</section>
</body>

</html>