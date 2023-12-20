<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>用户信息</title>
    <link rel="stylesheet" href="../static/styles/style.css">
    <script src="https://unpkg.com/jquery@3.4.0/dist/jquery.js"></script>
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

    let tbody = document.getElementById("body");
    for (let i = 0; i < rawData.length; i++) {
        let row = document.createElement("tr");
        for (let key in rawData[i]) {
            let cell = document.createElement("td");
            cell.appendChild(document.createTextNode(rawData[i][key]));
            row.appendChild(cell);
        }
        tbody.appendChild(row);
    }

    function del(id) {
        let xmlHttpRequest = new XMLHttpRequest();
        xmlHttpRequest.open("POST", "/delete", false)
        xmlHttpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xmlHttpRequest.send("id=" + id)
        xmlHttpRequest.onreadystatechange = function (data) {
            if (xmlHttpRequest.readyState === 4 && xmlHttpRequest.status === 200) {
                console.log(data);
            }
        }
        location.reload();
    }
</script>
</html>