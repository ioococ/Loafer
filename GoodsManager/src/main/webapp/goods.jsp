<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
    <title>信息页</title>
    <link rel="stylesheet" href="./styles/style.css">
</head>

<body>
<section class="container">
    <h1>用户信息</h1>
    <table>
        <tbody>
        <tr class="fixed">
            <td class="goodsName">商品名称</td>
            <td class="price">商品价格</td>
        </tr>
        </tbody>
    </table>
    <div class="info">
        <table>
            <tbody id="body">
            <c:forEach items="${sessionScope.goods}" var="good">
                <tr>
                    <td>${good.getGoodsName()}</td>
                    <td>${good.getPrice()}</td>
<%--                    <td>--%>
<%--                        <button class="del-btn" onclick="del(${user.getId()})">删除</button>--%>
<%--                    </td>--%>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</section>
</body>
<script>

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