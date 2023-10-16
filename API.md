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

