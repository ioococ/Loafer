<%@ page import="ink.onei.entity.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>用户信息</title>
    <link rel="stylesheet" href="../static/styles/style.css">
    <script src="https://unpkg.com/jquery@3.4.0/dist/jquery.js"></script>
    <link rel="stylesheet" href="../static/styles/notyf.css">
    <script src="../static/scripts/notyf.js" type="text/javascript"></script>
</head>
<%
    User userDetail = (User) session.getAttribute("userDetail");
    String avatar = userDetail.getAvatar();
%>

<body>
<section class="container">
    <h1>详细信息</h1>
    <div class="info" style="margin: 10px auto">
        <div style="margin-right: 20px;width: fit-content">
            <img id="avatarImg" src="/avatar/<%=avatar%>" alt="" width="290"
                 height="290" style="display: block;margin: 0 auto;border: #aaaaaa 1px solid">
            <input id="avatar" type="file" value="" accept="image/*">
            <button id="modify" onclick="modify()">更新头像</button>

        <%--    @formatter:off    --%>
        </div><table><tbody>
            <tr><td>用户ID</td><td>${userDetail.getId()}</td></tr>
            <tr><td>用户姓名</td><td>${userDetail.getUsername()}</td></tr>
            <tr><td>昵称</td><td>${userDetail.getNickname()}</td></tr>
            <tr><td>密码</td><td>${userDetail.getPassword()}</td></tr>
            <tr><td>性别</td><td>${userDetail.getSex()}</td></tr>
            <tr><td>年龄</td><td>${userDetail.getAge()}</td></tr>
            <tr><td>余额</td><td>${userDetail.getMoney()}</td></tr>
            </tbody></table></div>
        <%--    @formatter:on    --%>
</section>
</body>
<script>
    var notyf = new Notyf({delay: 2000});

    function modify() {
        //    获取input框的value，获取图片
        let avatarFile = document.getElementById("avatar").files[0];
        let avatarImg = document.getElementById("avatarImg");
        //    创建formData
        let formData = new FormData();
        formData.set("file", avatarFile)
        $.ajax({
            url: "modify",
            type: "POST",
            //不处理数据
            processData: false,
            //不设置content-type请求头
            contentType: false,
            data: formData,
            success: function (data) {
                avatarImg.src = "/avatar/" + data;
                notyf.confirm("头像更新成功");
            }
        })
    }
    function a() {
        notyf.alert("头像更新成功");
    }
    function b() {
        notyf.confirm("头像更新成功");
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