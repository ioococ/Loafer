# ☕ Java

## 🏗️ Java 技术栈

+ 程序基础
+ 面向对象
+ 数组
+ 异常机制
+ 常用API
+ 集合+Map
+ IO流
+ 多线程
+ 网络编程
+ 正则表达式
+ lambda表达式 + 函数式接口
+ 反射机制
+ GUI

## 🧭 Java 方向

- JavaSE
- JavaME
- JavaWEB
- JavaEE

## 🔰 Java 特性

+ 多线程
+ 跨平台
+ 面向对象
+ 自动垃圾回收

Java 属于静态强类型解释性语言

**静态类型** 创建变量时指定数据类型

**动态类型** 创建变量时无需指定数据类型 运行后赋值时确定数据类型

**强类型** 需通过强制转换类型 转换类型

**弱类型** 根据程序上下文环境自动修改数据类型

**编译型** 使用编译器来编译执行的编程语言

**解释型** 使用解释器来解释执行的编程语言x

<style>
    * {
        margin: 0;
        padding: 0;
        font-family: MiSans;
        line-height: fit-content;
    }

    #javac {
        margin-left: 60px;
        margin-right: 80px;
    }
    p{
        margin: 0;
    }
    #brand {
        margin: 0;
        margin-left: 180px;
        width: fit-content;
        border: 1px black solid;
    }
</style>
<section>
    <span id="javac">javac</span><span id="java">java</span>
    <p>xxx.java ----->xxx.class ----->Hello World</p>
    <p id="brand">Windows/Linux/MacOS</p>
</section>

## 结构

### 内存存储
电子位 bit 八位 一字节
<style>
    *{
        margin: 0;
        padding: 0;
        font-family: MiSans;
        box-sizing: border-box;
    }
        .bit{
        width: 40px;
        height: 40px;
        display: inline-block;
        border: 1px solid black;
    }
</style>
<div class="bit"></div><div class="bit"></div><div class="bit"></div><div class="bit"></div><div class="bit"></div><div class="bit"></div><div class="bit"></div><div class="bit"></div>

最高位为符号位

## 数据类型

### 基本数据类型

- 数值型
  - 整数型
    - byte 8bit
    - short 16bit
    - int 32bit
    - long 64bit
  - 浮点型 
    - float 32bit 
    - double 64bit 
- 布尔型 boolean
- 字符型 char


### 引用数据类型

## 注释

单行注释

```java
// XXX
```
多行注释
```java
/*
 * XXX
 * YYY
 */
```

```java
/**
 * XXX
 * YYY
 */
```
可生成 Javadoc 文档

## 命名

强制规则 只允许使用大小写字母 $ _ 数字 且数字不能开头 不能使用关键字和保留字

非强制规则 驼峰命名 见名之意