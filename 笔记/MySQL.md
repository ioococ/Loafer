# SQL 数据库

## 数据

**数据库解决操作系统之间的跨平台问题**

# 非关系型数据库

保存键值对。查询处理数据，得到数组

# 关系型数据库

查询来数据，得到数据

**ORM** (Object Relational Mapping) 对象关系映射
作用是在关系型数据库和对象之间做个映射。这样再具体的操作数据库的时候，就不必再去和复杂的SQL语句打交道

decimal(x,y) 小数 小数点后y位

数据表修改名称

数据相关用delete

# 数据类型

# 文本

char 定长
varchar 变长

# DDL 操作

Data Definition Language 数据库定义语言
用户创建 数据库创建 数据表创建

## 用户相关

- ``grant `权限` on `数据库`.`表` to '用户'@'主机' identified by '密码'``
  授予权限
- ``revoke 权限 on `数据库`.`表` from '用户'@'主机' identified by '密码'``
  撤销权限

**MySQL 8.0中不需要`identified by '密码'`**

刷新权限：`FLUSH PRIVILEGES`

## alter

- `alter table 旧表名 rename 新表名`
  重命名表
- `alter table 表名 change 旧字段名 新字段名 数据类型`
  重命名字段
- `alter table 表名 add 字段 数据类型`
  添加新字段
  - `alter table 表名 add 新字段 数据类型 after 指定字段`
  添加新字段到指定字段名之后
  - `alter table 表名 add 新字段 数据类型 first`
  添加新字段到表首
  - `alter table 表名 add 约束函数`
    添加字段约束
- `alter table 表名 drop 字段`
  删除表字段
- `alter table 表名 modify 字段名 数据类型`
  修改字段数据类型
  - `alter table 表名 modify 字段名 数据类型 comment '注释'`
    修改字段数据类型和注释
  - `alter table 表名 modify 字段名 数据类型 约束`
    添加字段约束

## DDL 增强

## 表约束

- `primary key` 主键约束
  等同于与`not null`和`unique`一同使用
  一般和`auto_increment`一同使用
  `primary key()`主键函数 参数可写多个（联合主键）
- `not null` 非空约束
  可与`default`一同使用
- `unique` 唯一约束
  多个空值可不唯一
  `unique(字段名)` 唯一函数 在定义字段后的结束括号内使用
- 外键约束
- 检查约束
  check **MySQL不支持**


rename table 旧表名 to 新表名

# DML 操作

DML: Data Manipulate Language(数据操作语言)，主要用于向数据库插入、修改、删除数据

## 插入

- `insert into 表名(字段...) values(值...)`
- `insert into 表名(字段...) values(值...),(值...)`
- `insert into 表名 values(值...)`
  需要设置所有列的值，并且按照列的先后顺序设置

## 删除

- `delete from 表名` 清空表
- `delete from 表名 where 字段=值` 删除表数据

### where

- `where 表名 is null` 是否为空
- `where 表名 is not null` 是否为不为空

## 修改

- `update 表名 set 列名=值[,列名=值]` 全表操作
- `update 表名 set 列名=值[,列名=值] [where]`

# DQL 操作

查询

- select 列限定
- from 表限定
- where 行限定

先执行表限定，再执行行限定，最后执行列限定。

# 条件判断

> , >= , <  , <= ,<>,=
> : 大于
< : 小于
>= : 大于等于
<= : 小于等于
= : 相等
<> : 不等于
判断为空不能使用 = null ,应该使用 **is null**
**and优先级大于or**

between  and

in

# 模糊匹配

like

% 匹配任意字符
_ 匹配单个字符

如果想要查询 _% 需要使用\转义

# 排序

order by 排序列名 默认为升序
asc 升序
desc 降序


# 限制

limit 条数
limit 开始值,条数 不包含开始值

# 单表查询\组函数

count(*) : 总条数
max(字段名) : 最大值
min(字段名) : 最小值
avg(字段名) : 平均值
sum(字段名) : 总和


# 子查询

# 多表查询

笛卡尔积

# 连接查询

inner join 不符合条件的
left outer join
right outer join