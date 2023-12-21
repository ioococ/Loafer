<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>信息页</title>
    <link rel="stylesheet" href="../static/styles/style.css">
    <link rel="stylesheet" href="../static/styles/notyf.css">
    <script src="https://unpkg.com/jquery@3.4.0/dist/jquery.js"></script>
    <script src="../static/scripts/notyf.js" type="text/javascript"></script>
</head>

<body>
<section class="container">
    <h1>用户信息</h1>
    <table>
        <tbody>
        <tr class="fixed">
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
            <tbody id="body">
            <c:if test="not empty ${sessionScope.users}">
                <tr>
                    <td>暂无数据</td>
                </tr>
            </c:if>
            <c:forEach items="${sessionScope.users}" var="user">
                <tr>
                    <td>${user.getUsername()}</td>
                    <td>${user.getNickname()}</td>
                    <td>${user.getSex()}</td>
                    <td>${user.getAge()}</td>
                    <td>${user.getMoney()}</td>
                    <td>
                        <button class="detail-btn" onclick="detail(${user.getId()})">修改</button>
                        <button class="del-btn" onclick="del(${user.getId()})">删除</button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</section>
</body>
<script>
    function detail(id) {
        window.location.href = "detail?id=" + id;
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