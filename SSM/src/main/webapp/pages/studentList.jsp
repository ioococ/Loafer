<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>展示账户数据列表</h1>
<table border="1">
    <tr>
        <th>SID</th>
        <th>NAME</th>
        <th>AGE</th>
        <th>SEX</th>
        <th>账户金额</th>
    </tr>

    <c:forEach items="${studentList}" var="stu">
        <tr>
            <td>${stu.s_}</td>
            <td>${stu.sname}</td>
            <td>${stu.sage}</td>
            <td>${stu.ssex}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
