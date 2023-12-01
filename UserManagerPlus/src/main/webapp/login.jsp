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
    <div id="login" class="form login">
        <header>登录</header>
        <input type="text" id="username" placeholder="用户名" required>
        <input type="password" id="password" placeholder="密码" required>
        <a href="#">忘记密码</a>
        <button class="btn" onclick="login()">登录</button>
    </div>
</section>
</body>
<script>
    var notyf = new Notyf({delay: 2000});
    let xhr = new XMLHttpRequest();

    function login() {
        let rawData;
        let type;
        let username = document.getElementById("username").value
        let password = document.getElementById("password").value
        xhr.open("POST", "/login", false)
        xhr.onreadystatechange = function (data) {
            let headers = xhr.getAllResponseHeaders().toLowerCase();
            let arr = headers.trim().split(/[\r\n]+/);
            let headerMap = {};

            arr.forEach(function (line) {
                let parts = line.split(': ')
                let header = parts.shift()
                let value = parts.join(': ')
                headerMap[header] = value
            })
            type = headerMap['type'];

            if (xhr.readyState === 4 && xhr.status === 200) {
                let pageData = data.target.responseText;
                if (type === "document") {
                    document.body.parentNode.innerHTML = pageData
                } else {
                    rawData = JSON.parse(pageData);
                }
            }
        }
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.send("username=" + username + "&password=" + password)

        if (type !== "document" && rawData.status == -1) {
            notyf.alert(rawData.msg)
        } else if (false) {
            notyf.confirm(rawData.msg)
            window.location.replace("/")
        }
    }

</script>

</html>