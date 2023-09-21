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

### byte 

取值 127~-128

### short 

取值 32767~-32768

### int 

取值 2147483647~-2147483648

### long 

需要以L或l结尾

### float 

需要以F或f结尾

### double 

需要以D或d结尾 或不写

### boolean

只有 true 和 false
### char

使用单引号表示 并且有且只有一个字符

char 范围 0~65535 不需要负数

支持Unicode编码 4bit 十六进制整型值 0~f  `\u0000` ~ `\uffff`

### 引用数据类型

- 类
- 数组 
- 接口

## 类型转换

布尔型 不能参与转换

- 低精度到高精度 可以自动类型转换
- 高精度 到低精度 需要强制类型转换

### 自动类型转换

byte --> short --> int --> long --> float --> double

char --> int --> long --> float --> double

### 强制类型转换

有可能损失精度

整数转换为char时 当不考虑符号位时 对应的是 `65271`

整数转换为char时 忽略负数 将响应负数的二进制转换为对应的正数 然后再进行ASCII码对照

## 多类型混合运算

当进行多类型混合运算时 结果为参与运算的最大类型

当混合运算类型 只出现了 byte short int char 四种类型时

王意一种或多种进行运算，结果一定是int类型(可以理解为,混合运算,结果为参与运算的最大类型,但最低也是int类型)

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

## 程序入口
