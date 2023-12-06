<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="bean.User" %>
<%@ page import="jakarta.servlet.ServletRequest" %><%--
  Created by IntelliJ IDEA.
  User: 荣耀
  Date: 2021/12/10
  Time: 8:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    pageContext.setAttribute("username", "张三");
    requset.setAttribute("username", "张三");
    session.setAttribute("username", "张三");
    application.setAttribute("username", "张三");
%>
<pre>
    获取pageContext中的username: ${pageScope.username}
    获取request中的username :${requestScope.username}
    获取session中的username :${sessionScope.username}
    获取application中的username :${applicationScope.username}
    获取一个不存在属性变量的值: ${aaaaa}
</pre>
<p>
    不指定空间对象的话，那最小的域对象去获取值: ${username}
</p>
<%
    String[] names = {"张三", "李四", "王五"};
    pageContext.setAttribute("names", names);
%>
<pre>
    name[1] = ${names[1]}
    name[5] = ${names[5]}
</pre>
<%--获取集合中属性的值--%>
<%
    List<String> list = new ArrayList<>();
    list.add("张三");
    list.add("李四");
    list.add("王五");
    pageContext.setAttribute("list", list);
%>
<pre>
    获取list中指定下标的数据：${list[1]} 下标从0开始
    获取list中连续的多数据：  ${list[1]}--${list[4]}
    获取集合长度：            ${list.size()}
</pre>
<%
    Map<String, Object> map = new HashMap<>();
    map.put("age", 20);
    map.put("name", "张三");

    pageContext.setAttribute("map", map);
%>
<pre>
    name = ${map.name}
    age = ${map.age}
</pre>
<%
    User user = new User();
    user.setName("张三");
    user.setAge(20);
    user.setSex("男");
%>
<pre>
获取javaBean中的username:${user.name}
获取javaBean中的age:${user.age}
获取javaBean中的sex:${user.sex}
</pre>
<%--11个隐含对象--%>
<%--pageContext对象--%>
<pre>
    1.协议
    ${pageContext.request.scheme}
    2.获取ip地址
    ${pageContext.request.serverName}
    3.获取端口号
    ${pageContext.request.serverPort}
    4.获取项目路径
    ${pageContext.request.contextPath}
    5.获取客户端ip
    ${pageContext.request.remoteHost}
    6.获取会话id
    ${pageContext.request.session.id}
    7.获取请求方式
    ${pageContext.request.method}
</pre>
<pre>
<%--    param和paramValue对象--%>
用param获取输出参数的值:
    获取username的值:${param.username}
    获取password的值:${param.password}
    用paramValue对象输出参数的值:
    输出参数: ${paramValues}
    输出username:${paramValues.username[0]}
    输出password:${paramValues.password[0]}
</pre>
<%--pageScope requestScope sessionScope applicationScope--%>
获取pageContext中的username: ${pageScope.username}
获取request中的username :${requestScope.username}
获取session中的username :${sessionScope.username}
获取application中的username :${applicationScope.username}
<pre>
<%--    header headerValues--%>
    输出请求头信息:
    ${header}
    输出header中的User-Agent的值:${header["User-Agent"]}
    输出header中的connction的值:${header.Connection}
    输出header中的connction的值:${header["Connection"]}
    headerValues:${headerValues.connection[0]}
</pre>
<pre>
<%--    获取cookie--%>
    获取cookie属性:${cookie.JESESSIONID.name}
    获取cookie值:${cookie.JESESSIONID.value}
</pre>
<pre>
<%--    获取cookie--%>
    获取XML属性:${cookie.JESESSIONID.name}
    获取cookie值:${cookie.JESESSIONID.value}
</pre>
<%--  11.iniParam来获取xml中配置的上下文--%>
<pre>
    读取XML中username的值：${initParam.username}
    读取XML中password的值：${initParam.password}
</pre>
<%
    pageContext.setAttribute("a", 1);
    pageContext.setAttribute("b", 2);
%>
<p>a+b的值为:${a+b}</p>
<%--empty--%>
<%
    String name1 = null;
    String name2 = "";
    List<String> name3 = new ArrayList<String>();
    pageContext.setAttribute("name1", name1);
    pageContext.setAttribute("name2", name2);
    pageContext.setAttribute("name3", name3);
%>
    <pre>
        empty对于没有定义的变量,运算结果为true
        empty namex = ${empty namex}
        empty对于null的变量,运算结尾为true
        empty name1 = ${empty name1}
        empty对于空字符串的,为true
        empty name2=${empty name2}
        empty对于没有元素的数组或集合，运算结果为true;
        empty name3=${empty name3}

    </pre>
</body>
</html>
