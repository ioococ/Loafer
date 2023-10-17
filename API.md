# String

String 为字符串类 在Java中是引用类型
String 底层为char数组 所以String很多特性都是数组的特性 例如String由length()方法保存长度
字符串一旦确定 不能修改

## 构造方法

- 字符数组转字符串
  `new String(char[])`
- 字节数组转字符串
  `new String(byte[])`
  - 选取字节数组位置转字符串
    `new String(byte[],index,last)`

## 常用方法

- `indexOf()`
  从头查找某字符的索引 找不到返回-1
- `lastIndexOf()`
  从尾查找某字符的索引 找不到返回-1
- `charAt()`
  获取字符串中索引处的字符
- `trim()`
  去除字符串中两边的空格
- `startsWith()`
  判断是否以指定字符串开头
- `endsWith()`
  判断是否以指定字符串结尾
- `toUpperCase()`
  转大写
- `toLowerCase()`
  转小写
  截取字符串
- `toCharArray()`
  转字符数组
- `getBytes()`
  转字节数组
- `replace()`
  替换
  - `replaceAll()`
    包含正则表达式的替换
- `split()`
  以指定字符串分割为字符串数组
- `equalsIgnoreCase()`
  不区分大小写比较

# StringBuffer/StringBuilder

`StringBuffer`线程安全 多线程环境下不会出现问题
`StringBuilder`线程不安全 多线程环境下可能出现问题

## 常用方法

- `append()`
  字符串拼接
- `capacity()`
  获取容量

# 包装类

# System

# Collection

- add()
- addAll()
- remove()
- removeAll()
- clear()
- isEmpty()
- contains()

contains和remove都会调用equals方法

**没有提供修改和查询的方法**

# iterator

迭代器

主要做遍历操作 使用迭代器可以屏蔽数据结构之间的差异性

- hasNext()
- next()
- remove()

迭代器一旦生成 集合将不能被修改 否则需要重新生成迭代器

## 增 强for循环

迭代器的简写方式 同样不能删除

# List

有序 可重复

## ArrayList

底层为Object数组

- add(index,items)
- set(index,items)
- size()

## LinkedList

底层为双向链表 随机添加和删除效率高

- add(index,items)
- set(index,items)
- size()