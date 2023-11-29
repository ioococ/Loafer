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
<section class="wrapper">
    <div class="form singup">
        <header>注册</header>
        <input type="text" id="username" placeholder="昵称" name="username">
        <input type="email" id="email" placeholder="电子邮件">
        <input type="password" id="password" placeholder="密码" name="password">
        <div class="checkbox">
            <input type="checkbox" id="check" checked>
            <label for="check">我接受用户条款</label>
        </div>
        <button class="btn" onclick="singup()">注册</button>
    </div>
</section>
</body>
<script>
    var notyf = new Notyf({delay: 2000});
    let xhr = new XMLHttpRequest();

    // var rawData = null;
    function singup() {
        let rawData;
        let username = document.getElementById("username").value
        let password = document.getElementById("password").value
        xhr.open("POST", "/signup", false)
        xhr.onreadystatechange = function (data) {
            if (xhr.readyState === 4 && xhr.status === 200) {
                console.log(data);
                rawData = JSON.parse(data.currentTarget.response);
            }
        }
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.send("username=" + username + "&password=" + password)
        if (rawData.status == -1) {
            notyf.alert(rawData.msg)
        } else {
            notyf.confirm(rawData.msg)
            window.location.replace("/")
        }

    }

</script>

</html>