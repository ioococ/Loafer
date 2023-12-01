<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">

<%
    if (session.getAttribute("user") == null) {
        response.sendRedirect("/login.jsp");
    }
%>
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
<section class="container">
    <h1>用户信息</h1>
    <table>
        <tbody>
        <tr class="fixed" style="">
            <td class="name">用户</td>
            <td class="sex">性别</td>
            <td class="email">电子邮件</td>
            <td class="tel">电话</td>
            <td class="birthday">生日</td>
            <td class="nickname">昵称</td>
            <td class="createdate">创建时间</td>
        </tr>
        </tbody>
    </table>
    <div class="info">
        <table>
            <tbody id="body"></tbody>
        </table>
    </div>
</section>
</body>
<script>
    var notyf = new Notyf({delay: 2000});
    let xhr = new XMLHttpRequest();
    let rawData;
    xhr.open("POST", "/info", false)
    xhr.onreadystatechange = function (data) {
        if (xhr.readyState === 4 && xhr.status === 200) {
            console.log(data);
            rawData = JSON.parse(data.currentTarget.response);
        }
    }
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.send()
    var datas = rawData.Arrays;

    for (let users of datas) {
        let trElement = document.createElement("tr");
        body.appendChild(trElement);
        for (let data of users) {
            let tdElement = document.createElement("td");
            trElement.appendChild(tdElement);
            tdElement.innerText = data;
        }
    }

</script>

</html>