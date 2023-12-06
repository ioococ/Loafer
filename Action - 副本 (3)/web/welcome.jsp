<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>Welcome</title>
</head>
<body>

<h1></h1>
<div align="center">
    <b>if else 用法</b>
    <s:if test="name=='ZhangSan'">你选择的人员名称是:张三</s:if>
    <s:elseif test="name=='LiSi'">你选择的人员名称是:李四</s:elseif>
    <s:else>你没有选择张三或是李四</s:else>
</div>

</body>
</html>