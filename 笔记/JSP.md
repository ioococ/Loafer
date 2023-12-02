# MVC 开发模式

- M：Model，模型。JavaBean
   - 完成具体的业务操作，如：查询数据库，封装对象
- V：View，视图。JSP
   - 展示数据
- C：Controller，控制器。Servlet
   - 获取用户的输入
   - 调用模型
   - 将数据交给视图进行展示

## 优缺点
- 优点：
   - 耦合性低，方便维护，可以利于分工协作
   - 重用性高
- 缺点：
   - 使得项目架构变得复杂，对开发人员要求高

# EL 表达式

## 为什么需要EL表达式

`<%!%>`、`<%%>`、`<%=%>` 高耦合

## 语法

`${expr}`
JSP 默认支持EL表达式,如需关闭可在page中指明 `isELIgnore=true`
`\${expr}` 忽略当前这个el表达式

`${域名称.键名}`：从指定域中获取指定键的值

|     |       域名称        |            域对象             |   作用范围    |
|-----|:----------------:|:--------------------------:|:---------:|
|     |    pageScope     |        pageContent         | 当前JSP页面范围 |
| 请求域 |   requestScope   |          request           |   一次请求    |
| 会话域 |   sessionScope   |          session           |   一次会话    |
| 共享域 | applicationScope | application/ServletContent |  整个web应用  |

`${键名}` 表示依次从最小的域中查找是否有该键对应的值，直到找到为止

**获取对象、List集合、Map集合的值**
1. 对象：`${域名称.键名.属性名}`
   本质上会去调用对象的getter方法
2. List集合：`${域名称.键名[索引]}`
3. Map集合：
`${域名称.键名.key名称}`
`${域名称.键名["key名称"]}`

## 运算

1. 算数运算符： `+` `-` `*` `/(div)` `%(mod)`
2. 比较运算符： `>` `<` `>=` `<=` `==` `!=`
3. 逻辑运算符： `&&(and)` `||(or)` `!(not)`
4. 空运算符： `empty`
  功能：用于判断字符串、集合、数组对象是否为null或者长度是否为0
  `${empty list}` 判断字符串、集合、数组对象是否为null或者长度为0
  `${not empty str}` 表示判断字符串、集合、数组对象是否不为null 并且 长度>0

# JSTL

## 概念

JSTL : JSP Standard Tag Library (JSP标准标签库)

# 会话管理

# 无状态协议

无状态是指协议对于事务处理没有记忆能力，服务器不知道客户端是什么状态。即我们给服务器发送 HTTP 请求之后，服务器根据请求，会给我们发送数据过来。但是，发送完不会记录任何信息。
Http连接本身是无状态的，即前一次发起的连接跟后一次没有任何关系，是属于两次独立的连接请求，但是互联网访问基本上都是需要有状态的，即服务器需要知道两次连接请求是不是同一个人访问的。
缺少状态意味着如果后续处理需要前面的信息，则它必须重传，这样可能导致每次连接传送的数据量增大。另一方面，在服务器不需要先前信息时它的应答就较快。
客户端与服务器进行动态交互的 Web 应用程序出现之后，HTTP 无状态的特性严重阻碍了这些应用程序的实现。于是，两种用于保持 HTTP 连接状态的技术就应运而生了，一个是 Cookie，而另一个则是 Session。

# 会话

**一次会话中包含多次请求和响应。**
一次会话：浏览器第一次给服务器资源发送请求，会话建立，直到有一方断开为止


# Cookie

客户端会话技术，将数据保存到客户端

**实现原理**
基于响应头set-cookie和请求头cookie实现

**JSESSIONID**
唯一标识号，用来标识服务器端的Session，也用来标识客户端的Cookie，客户端和服务器端通过这个JSESSIONID来一一对应。

## 特点

1. cookie存储数据在客户端浏览器
2. 单个cookie最大4kb 同一域名总cookie最多20个

## 作用

1. cookie一般用于存储少量的不太敏感的数据
2. 在不登录的情况下，完成服务器对客户端的身份识别

## 细节

**一次发送多个cookie**
- 可以 创建多个Cookie对象，使用response调用多次`addCookie()`方法设置cookie即可。

**cookie在浏览器中保存时间**
  - 默认情况下，当浏览器关闭后，Cookie数据被销毁
  - 持久化存储：
    `setMaxAge(int seconds)`
      正数：将Cookie数据写到硬盘的文件中。持久化存储。并指定cookie存活时间，时间到后，cookie文件自动失效
      负数：默认值
      零：删除cookie信息
  
**cookie存中文**
- 在tomcat 8 之前 cookie 中不能直接存储中文数据。
- 需要将中文数据转码（一般采用URL编码(%E3)）

**cookie共享问题**
  - 默认情况下cookie不能共享
    - `setPath(String path)` 设置cookie的获取范围。默认情况下，设置当前的虚拟目录
    - 如果要共享，则可以将path设置为 `/`
- 不同的tomcat服务器间cookie共享问题？
    - `setDomain(String path)` 如果设置一级域名相同，那么多个服务器之间cookie可以共享
    - `setDomain(".baidu.com")` 那么tieba.baidu.com和news.baidu.com中cookie可以共享

# Session

服务器端会话技术，在一次会话的多次请求间共享数据，将数据保存在服务器端的对象中。

# 细节

**当客户端关闭后，服务器不关闭，两次获取session是否为同一个？**
  默认情况下不是
  如果需要相同，则可以创建Cookie,键为JSESSIONID，设置最大存活时间，让cookie持久化保存。

**客户端不关闭，服务器关闭后，两次获取的session是同一个吗？**
  不是同一个，但是要确保数据不丢失。tomcat自动完成以下工作
    session的钝化
      在服务器正常关闭之前，将session对象序列化到硬盘上
    session的活化
      在服务器启动后，将session文件转化为内存中的session对象

**session什么时候被销毁**
1. 服务器关闭
2. session对象调用 `invalidate()`
3. session默认失效时间 30分钟
  选择性配置修改
  ```xml
  <session-config>
    <session-timeout>30</session-timeout>
  </session-config>
  ```

# session与Cookie的区别

1. session存储数据在服务器端，Cookie在客户端
2. session没有数据大小限制，Cookie有4kb
3. session数据安全，Cookie相对于不安全






















