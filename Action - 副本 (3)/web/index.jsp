<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 荣耀
  Date: 2022/3/9
  Time: 9:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>INDEX</title>
</head>
<body>
<div align="center">
    <form action="hello.action">
        <label for="name.action">请选择姓名</label>
        <select id="name.action" name="name">
            <option name="ZhangSan">张三</option>
            <option name="LiSi">李四</option>
            <option name="WangWu">王五</option>
        </select>
        <input type="submit" value="OK">
    </form>
    <hr>
    <h1>iterator</h1>
    <table border="1px" cellpadding="0" cellspacing="0">
        <s:iterator var="name" value="{'星期名称','星期一','星期儿','星期三','星期四','星期五','星期六','星期日'}">
            <s:if test="#st.odd">
                <tr style="background-color: aliceblue">
                    <td><s:property value="name"/></td>
                </tr>
            </s:if>
        </s:iterator>
    </table>
    <hr>
    <s:property value="'这里是数据标签'"/>
    <hr>
    <s:property value="'<p>这里是数据标签</p>'" escapeHtml="true"/>
    <hr>
    <s:property value="'<p>这里是数据标签</p>'" escapeHtml="false"/>
    <hr>
    <s:property value="" default="default"/>
    <p></p>
    <p></p>
    <p></p>
    <s:include value="infile.jsp">
        <s:param name="param" value="Hello"/>
    </s:include>
    <s:debug>ClickMe</s:debug>
    <p></p>
    <p></p>
    <p></p>
    <s:form action="login">
        <s:textfield label="name" name="username"/>
        <s:password label="pwd" name="password"/>
        <s:password label="apwd" name="password"/>
        <s:radio label="sex" list="#{'0':'male','1':'female'}" value="0" name="sex"/>
        <s:textarea label="Sign" name="description" rows="5" cols="15"/>
        <s:submit value="提交"/>
    </s:form>
    
    <s:select label="选择所学的内容" name="select" list="#{'JavaWeb':'JavaWeb','数据库':'数据库'}"
              listKey="value" listValue="key">
        <s:optgroup label="JavaWeb" list="#{'JSP':'JSP','Servlet':'Servlet','JavaBean':'JavaBean'}"
                    listKey="value" listValue="key"/>
        <s:optgroup label="数据库" list="#{'Oracle':'Oracle','MySQL':'MySQL','SQLserver':'SQLserver'}"
                    listKey="value" listValue="key"/>
    </s:select>

</div>
</body>
</html>
