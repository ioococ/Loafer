<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>添加账户信息表单</h1>
<form name="accountForm" action="${pageContext.request.contextPath}/student/save" method="post">
    姓名:<input type="text" name="sname">
    性别:<input type="text" name="ssex">
    年龄:<input type="text" name="sage">
    <input type="submit" value="保存"><br>
</form>
</body>
</html>
