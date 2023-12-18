# Mybatis

# 什么是Mybatis

Mybatis 是一款优秀的持久层框架，用于简化JDBC
MyBatis本来是Apache的一个开源项目iBatis，2010年这个项目由apache software foundation迁移到了google code，并且改名为MyBatis。2013年11月迁移到Github

持久层：负责将数据保存到数据库的一层。
JavaEE三层架构：表现层、业务层、持久层 

框架：一套可重用的、通用的软件基础代码模型。

# 配置

## 核心配置文件

存储在 `Mybatis-config.xml` 文件中，配置文档的顶层结构如下：

```
configuration
├───properties                 属性
├───settings                   设置
├───typeAliases                类型别名
├───typeHandlers               类型处理器
├───objectFactory              对象工程
├───plugins                    插件
├───environments               环境配置
│   └───environment            环境变量
│       ├───transactionManager 事务管理器
│       └───dataSource         数据源
├───databaseIdProvider         数据库厂商标识
└───mapper                     映射器
```

transactionManager标签用于设置事务管理器用于MyBatis的事务管理。MyBatis 支持两种事务管理器类型：
`JDBC` 需要在程序中使用通过SqlSession对象的commit()方法提交，通过rollback()方法回滚，默认情况下是需要手动提交的。
`MANAGED` 由Mybatis来管理事务的整个事务的生命周期，默认情况下，每次操作都会关闭数据库连接。

dataSource标签主要用于配置应用的数据源连接方式和数据库连接信息，使用type属性来设置数据源类型：
`UNPOOLED` 表示不使用数据库连接池，每次数据库操作Mybatis都需要创建一个Connection对象。
`POOLED` 使用Mybatis提供的数据库连接池。
`JNDI` 使用JNDI数据源（JNDI的方式一般是配置在应用服务器中）

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <properties resource="jdbc.properties"/>
  <settings>
    <setting name="logImpl" value="LOG4J"/>
  </settings>
  <typeAliases>
    <package name="ink.onei.entity"/>
  </typeAliases>
  <environments default="development">
    <environment id="development">
      <transactionManager type="JDBC"/>
      <dataSource type="POOLED">
        <property name="driver" value="${driver}"/>
        <property name="url" value="${url}"/>
        <property name="username" value="${username}"/>
        <property name="password" value="${password}"/>
      </dataSource>
    </environment>
      <!--测试环境 -->
    <environment id="test">
      <transactionManager type="JDBC" />
      <dataSource type="POOLED">
        <property name="driver" value="${jdbc.test.driver}" />
        <property name="url" value="${jdbc.test.url}" />
        <property name="username" value="${jdbc.test.user}" />
        <property name="password" value="${jdbc.test.password}" />
      </dataSource>
    </environment>
  </environments>
  <mappers>
    <mapper resource="mapper/UserMapper.xml"/>
  </mappers>
</configuration>
```

**配置各个标签时需要遵守前后顺序**

## Mapper

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="ink.onei.mapper.IUserDao">
    <insert id="insert" parameterType="User">
        insert into user
        (username, password, sex, phone, email, birthday, nickname, createdate)
        values (#{username},#{password},#{sex}, #{phone},#{email},#{birthday},#{nickname},#{createdate})
    </insert>
    <select id="select" parameterType="int" resultType="User">
        select * from user where id = #{id}
    </select>
</mapper>
```

- parameterType 入参类型
- resultType 返回值类型
- resultMap 结果映射

resultMap
参数
- id 当前命名空间中的一个唯一标识，用于标识一个ResultMap
- type 类的完全限定名, 或者一个类型别名 (内置的别名可以参考上面的表格).
- autoMapping 如果设置这个属性，MyBatis将会为这个ResultMap开启或者关闭自动映射。这个属性会覆盖全局的属性 autoMappingBehavior。默认值为：unset。

子标签
id 一个 ID 结果;标记出作为 ID 的结果可以帮助提高整体性能
result 注入到字段或 JavaBean 属性的普通结果
association 一个复杂类型的关联;许多结果将包装成这种类型
collection 一个复杂类型的集合
  嵌套结果映射 – 集合可以指定为一个 resultMap 元素，或者引用一个
discriminator – 使用结果值来决定使用哪个 resultMap

### association 标签属性

关联的嵌套查询

- property 映射到列结果的字段或属性。如果用来匹配的 JavaBean 存在给定名字的属性，那么它将会被使用。否则 MyBatis 将会寻找给定名称的字段。
- column 来自数据库的列名,或重命名的列标签。这和通常传递给 resultSet.getString(columnName)方法的字符串是相同的。 
- javaType 一个 Java 类的完全限定名，或一个类型别名
- select 另外一个映射语句的 ID,可以加载这个属性映射需要的复杂类型。获取的 在列属性中指定的列的值将被传递给目标 select 语句作为参数。
- autoMapping

### collection 标签属性

- property
- column
- ofType
- select
- autoMapping

```xml
<resultMap id="userMap" type="User" autoMapping="true">
    <result column="createdate" property="createdate" jdbcType="DATE"/>
</resultMap>

<!--  地址-用户 一对一关系 Mapper 使用连接语句 -->
<resultMap id="AddressUserMapWithJoin" type="AddressAndUserVO" autoMapping="true">
    <id column="id" property="id"/>
    <association property="user" javaType="User" column="userid" autoMapping="true">
        <id column="uid" property="id"/>
    </association>
</resultMap>

<select id="AddrAndUserVo" resultMap="AddressUserMapWithJoin">
  select a.*,u.id as uid,u.*
  from address a
    left join user u on a.userid = u.id
  where u.id = #{id}
</select>

<!--  用户-地址 一对多关系 Mapper 使用连接语句 -->
<resultMap id="UserAndAddressMapWithJoin" type="UserAndAddressVO" autoMapping="true">
    <id column="id" property="id"/>
    <collection property="addressList" ofType="Address" javaType="list" column="id" autoMapping="true">
        <id column="aid" property="id"/>
    </collection>
</resultMap>

<select id="userAndAddress" resultMap="UserAndAddressMapWithJoin">
  select u.*, a.*, a.id as aid
  from user u
    left join address a on u.id = a.userid
  where u.id = #{id}
</select>
```

# 使用方式

## 接口代理

- 设置SQL映射文件的namespace属性为Mapper接口全限定名
  `<mapper namespace="ink.onei.dao.IUserDao">`
- 在 Mapper 接口中定义方法，方法名就为SQL映射文件中sql语句的id，并保持参数类型和返回值类型一致
- 在核心配置文件下mappers标签指定SQL映射文件的位置
  `<mapper resource="mapper/UserMapper.xml"/>`
- 使用SqlSession对象调用getMapper()方法动态代理获取Mapper对象，调用Mapper中的方法来执行SQL语句

```java

// 加载mybatis的核心配置文件，获取SqlSessionFactory
String config = "mybatis-config.xml";

// 返回一个字节输入流
InputStream inputStream = Resources.getResourceAsStream(config);
SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

// 获取SqlSession对象，用它来执行sql
SqlSession session = factory.openSession();

// 获取UserMapper接口的代理对象
IUserDao userDao = session.getMapper(IUserDao.class);
User user = new User("root", "root", "男", "11111", "1@1.com", new Date(997718400), "root");
userDao.insert(user);
session.commit();

//释放资源
sqlSession.close();
```

如果Mapper接口名称和SQL映射文件名称相同，并在同一目录下，则可以使用包扫描的方式简化SQL映射文件的加载

```xml

<mappers>
    <package name="ink.onei.mapper"/>
</mappers>
```

## XML 声明

```java
String resource = "mybatis-config.xml";

// 读取总配置文件
InputStream inputStream = Resources.getResourceAsStream(resource);

// 获取session工厂
SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

// 获取session
SqlSession session = sqlSessionFactory.openSession();
User user = new User("root", "root", "男", "11111", "1@1.com", new Date(997718400), "root");

// 调用xml中的sql
session.insert("User.add", user);

// 提交
session.commit();
```

## 注解

-	注解方式不需要SQL映射文件 
-	需要再对应的接口上添加对应的注解语句
-	mybatis-config.xml中添加映射配置

在dao层接口上直接添加sql注解
```java
public interface IUserMapper {
    @Select("select * from t_user where id = #{id}")
    User getById(int id);
}
```

配置mybatis

```xml

<mappers>
    <!--配置到对应的包-->
    <package name="ink.onei.mapper"/>
</mappers>
```

运行

```java
IUserDao userDao = session.getMapper(IUserDao.class);
User user = session.getMapper(IUserMapper.class).getById(1);
```

# 封装

解决数据库表的列名(brand_name)与实体类(brandName)的属性名不匹配方案（数据库表的字段名称和实体类属性名称不一样，则不能自动封装数据）：

**方案一**：起别名，对不一样的列名起别名，让别名和实体类的属性名相同
  缺点：每次查询都要定义一次别名

```xml
<select id="selectAll" resultType="brand">
  select id, brand_name as brandName, company_name as companyName,
    ordered,description, status
  from tb_brand;
</select>
```

使用 resultMap 参数

- id：完成主键字段的映射
- column：数据库表的列名
- property：对应的实体类属性名 

```xml
<resultMap id="brandResultMap" type="brand">
  <result column="brand_name" property="brandName"/>
  <result column="compnamy_name" property="companyName"/>
</resultMap>
 
<select id="selectAll" resultMap="brandResultMap">
  select * from tb_brand;
</select>
```

**方案二**：在mybatis-config.xml中设置`<configuration>`中的`<setting>`标签的value值为true（开启驼峰命名自动映射，即从经典数据库列名 A_COLUMN 映射到经典 Java 属性名 aColumn。）

```xml
<settings>
  <setting name="mapUnderscoreToCamelCase" value="true"/>
</settings>
```

## 占位符

* 参数占位符
  1. `#{}`：将其替换为 `?` ,为了防止SQL注入
  2. `${}`：拼SQL，会存在SQL注入
  3. 使用时机：
    * 参数传递时，用 `#{}`
    * 表名或者列名不固定的情况下，`${}` 一定会存在SQL注入问题

* 参数类型：`parameterType` 用于设置参数类型，可以省略
* 特殊字符处理：
  1. 转义字符(eg：`&lt;`转义为 `<`)
  2. CDATA区(CD+enter，CD提示,将符号写在括号内)

# 联查

## 表间关系

- 一对一
  身份证、护照等证件 一个证件只能属于一个人
- 一对多
  用户和订单产品 一个用户可以多个订单产品
  部门和员工 一个部门可以有很多员工
- 多对一
  订单和用户 多个订单属于同一个用户
- 多对多
  学生选课和学生 一个学生可以选择多门课 一门课可以被多个学生选择

## 一对一

### 使用 `association` 标签

### 使用 SQL 直接联查

## 一对多

### 使用 `collection` 标签

### 使用 SQL 直接联查

# 分页

## 如何设计分页

- 每页有多少个pageSize
- 当前是在第几页pageNum
- 数据的总数total
- 数据列表list

基于这些属性设计分页的实体类(dto)

```java
@Data
public class PageInfo<T> {
  /**
    * 每页有多少个
   */
  private int pageSize;
  /**
   * 当前是在第几页
   */
  private int currentPage;
  /**
   * 数据的总数
   */
  private int total;
  /**
   * 数据列表
   */
  private List<T> list;
    
  // 获取偏移量
  public int getOffset() {
    return (this.currentPage - 1) * this.pageSize;
  }
}
```

## 实现分页功能

### 创建分页查询方法

```java
	/**
     * 分页查询
     *
     * @param user     查询条件
     * @param offset   起始位置
     * @param pageSize 每页容量
     * @return 用户列表
     */
    List<User> page(@Param("user") User user, @Param("offset") int offset, @Param("pageSize") int pageSize);

    /**
     * 统计总数
     *
     * @param user 查询条件
     * @return 总数
     */
    int count(@Param("user") User user);
```
SQL映射文件
```xml
<select id="page" resultType="User">
  select * from t_user
  <where>
    <if test="user.nickname != null and user.nickname != ''">
        and nickname like concat('%',#{user.nickname},'%')
    </if>
    <if test="user.username != null and user.username != ''">
      and username = #{user.username}
    </if>
    </where>
    limit #{offset},#{pageSize};
</select>
<select id="count" resultType="int">
    select count(*) from t_user
  <where>
      <if test="user.nickname != null and user.nickname != ''">
        and nickname like concat('%',#{user.nickname},'%')
      </if>
      <if test="user.username != null and user.username != ''">
          and username = #{user.username}
      </if>
  </where>
</select>
```
测试
```java
public void page(){
  PageInfo<User> pageInfo = new PageInfo<User>();
  pageInfo.setCurrentPage(1);
  pageInfo.setPageSize(10);
  User user = new User();
  user.setNickname("尚云");
  // 加上筛选条件，根据nickname 或 username进行筛选
  List<User> list = userMapper.page(user,pageInfo.getOffset(),pageInfo.getPageSize());
  pageInfo.setList(list);
  pageInfo.setTotal(userMapper.count(user));
  System.out.println(pageInfo);
}
```

# 自动分页

## 引入依赖

```xml
<dependency>
  <groupId>com.github.pagehelper</groupId>
  <artifactId>pagehelper</artifactId>
  <version>5.2.0</version>
</dependency>
```

## 配置拦截器

在mybatis的配置文件中增加插件 注意书写位置

```xml
<plugins>
  <!-- com.github.pagehelper为PageHelper类所在包名 -->
  <plugin interceptor="com.github.pagehelper.PageInterceptor">
    <!-- 使用下面的方式配置参数，后面会有所有的参数介绍 -->
    <property name="param1" value="value1"/>
  </plugin>
</plugins>
```

## 使用

```java
public void testList() throws IOException {
  SqlSession session = MybatisUtils.openSession();
  User condition = new User();
  // 插件里提供的分页工具,在要查询之前，执行一下PageHelper.startPage（当前页数，每页的容量）, 当使用工具时候，会导致懒加载失败
  // 加了这个操作，插件就会在sql语句中拼接limit限制，并且还会统计总个数
  PageHelper.startPage(1,5);
  List<User> users = session.getMapper(IUserMapper.class).list(condition);
  // 拿到结果之后通过PageInfo.of() 的方法，获得pageInfo
  com.github.pagehelper.PageInfo<User> list = com.github.pagehelper.PageInfo.of(users);
  System.out.println(users);
}
```

# 事务

## 事务四大特性

- 原子性
  事务必须是一个原子的操作序列单元。事务中包含的各项操作在一次执行过程中，只允许出现两种状态之一，要么都成功，要么都失败
- 一致性
  事务的执行不能破坏数据库数据的完整性和一致性，一个事务在执行之前和执行之后，数据库都必须处以一致性状态。
- 隔离性
  在并发环境中，并发的事务是互相隔离的，一个事务的执行不能被其它事务干扰
- 持久性
  事务一旦提交后，数据库中的数据必须被永久的保存下来。即使服务器系统崩溃或服务器宕机等故障。只要数据库重新启动，那么一定能够将其恢复到事务成功结束后的状态

## 脏读

脏读就是指当一个事务正在访问数据，并且对数据进行了修改，而这种修改还没有提交到数据库中，这时，另外一个事务也访问 这个数据，然后使用了这个数据。

## 不可重复读

是指在一个事务内，多次读同一数据。在这个事务还没有结束时，另外一个事务也访问该同一数据。那么，在第一个事务中的两 次读数据之间，由于第二个事务的修改，那么第一个事务两次读到的数据可能是不一样的。这样就发生了在一个事务内两次读到的数据是不一样的，因此称为是不可重复读。

## 幻读

是指当事务不是独立执行时发生的一种现象，例如第一个事务对一个表中的数据进行了修改，这种修改涉及到表中的全部数据行。 同时，第二个事务也修改这个表中的数据，这种修改是向表中插入一行新数据。那么以后就会发生操作第一个事务的用户发现表中还有没有修改的数据行，就好像发生了幻觉一样。

## 事务隔离级别

✔️：可能出现
❌：不会出现

|                  | 脏读  | 不可重复读 | 幻读  |                                说明                                 |
| ---------------- | :---: | :--------: | :---: | :-----------------------------------------------------------------: |
| Read uncommitted |   ✔️   |     ✔️      |   ✔️   |   读未提交 即使一个更新语句没有提交,但是别的事务可以读到这个改变    |
| Read committed   |   ❌   |     ✔️      |   ✔️   |  读已提交 语句提交以后即执行了COMMIT以后，别的事务才能读到这个改变  |
| Repeatable read  |   ❌   |     ❌      |   ✔️   | 可重复读 同一个事务里面先后执行同一个查询语句的时得到的结果是一样的 |
| Serializable     |   ❌   |     ❌      |   ❌   |           序列化 这个事务执行的时候不允许别的事务并发执行           |
