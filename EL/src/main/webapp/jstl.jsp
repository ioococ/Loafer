<%--
  Created by IntelliJ IDEA.
  User: nekotako
  Date: 01/12/2023 15:19
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${applicationScope.list}" var="every">
    <tr>
        <td>${every}</td>
    </tr>
</c:forEach>
</body>
</html>
