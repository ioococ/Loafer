<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 荣耀
  Date: 2022/3/8
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <div align="center">
    <s:debug/>
    Name: <s:property value="p.name"/>
    <p></p>
    Price: <s:property value="p.price"/>
  </div>
  </body>
</html>
