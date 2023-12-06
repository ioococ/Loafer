<%--
  Created by IntelliJ IDEA.
  User: 荣耀
  Date: 2021/12/10
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    ${fn:toUpperCase("asdasd")}
    <%--    <c:set/>在指定与中田间属性变量并复制--%>
    <c:set var="user" scope="session" value="${18000}"/>
    <%--    <c:out/>输出El值--%>
    <c:out value="${user}"/>
    <%--    <c:remove/>输出El值--%>
    <c:remove var="user"/>
    <p>删除后user变量后的值: <c:out value="${user}"/></p>
    <%--    <c:catch>异常处理--%>
    <c:catch var="catchException">
        <%int a=1/0;%>
    </c:catch>
    <c:if test="${catchException != null}">
        <p>异常为：${catchException}</p>
        <p>异常内容为：${catchException.message}</p>
    </c:if>

<%--    ${}--%>
<%--    ${}--%>
<%--    ${}--%>
<%--    ${}--%>
<%--    ${}--%>
<%--    ${}--%>
<%--    ${}--%>
<%--    ${}--%>
<%--    ${}--%>
<%--    ${}--%>
<%--    ${}--%>
<%--    ${}--%>
<%--    ${}--%>
<%--    ${}--%>
<%--    ${}--%>
</body>
</html>
