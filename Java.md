# ☕ Java 入门

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

## 📌 Java 方向

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

**解释型** 使用解释器来解释执行的编程语言

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

## 💾 结构

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

## 🧾 数据类型

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

⚠️ **注意**

- byte 
  取值 `127`~-`128`
- short 
  取值 `32767`~-`32768`
- int 
  取值 `2147483647`~-`2147483648`
- long 
  需要以`L`或`l`结尾
- float 
  需要以`F`或`f`结尾
- double 
  需要以`D`或`d`结尾 或不写
- boolean
  只有 `true` 和 `false`
- char
  使用单引号表示 并且有且只有一个字符
  char 范围 `0`~`65535` 不需要负数
 支持Unicode编码 4bit 十六进制整型值 0~f  `\u0000` ~ `\uffff`

### 引用数据类型

- 类
- 数组 
- 接口

## 💱 类型转换

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

当混合运算类型只出现了 byte short int char 四种类型时

任意一种或多种进行运算，结果一定是int类型(可以理解为 混合运算 结果为参与运算的最大类型 但最低也是int类型)

## 💬 注释

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

## 📛 命名

强制规则 只允许使用大小写字母 `$` `_` 数字 且数字不能开头 不能使用关键字和保留字

非强制规则 驼峰命名 见名之意

## 🏃 变量

### 全局变量

全局变量一般是指可以直接调用 不需要二次引用的变量

**Java 中不存在全局变量**

### 变量声明

使用**数据类型划分内存空间** 给空间取名字 并赋值

### 变量分类

分为三类
- 局部变量 在方法中写的变量
  无初始值 需初始化
- 静态变量 在类体中 使用 `static` 修饰的变量
- 成员变量 在类体中 没有使用 `static` 修饰的变量 存放在堆内存中

### 默认值

- 整数 `0`
- 小数 `0.0`
- 字符 `\u0000`
- 布尔 `false`
- 引用 `null`

### 作用域

静态变量调用 使用类名.静态变量名 需要考虑权限修饰符

### 区分

使用类名区分同名的局部变量和静态变量

使用 `this` 区分同名的局部变量和成员变量

### 优先级

局部变量可以和静态变量/成员变量**可同名**

静态变量和成员变量 **不可同名**

## 📐 运算符

### 算术运算符

### 关系运算符

`> >= < <= == !=` 结果是布尔型

`==` 基本类型比较值 引用类型比较内存地址

### 逻辑运算符

- `&` `&&` 与
  支持与运算 两边是数字 即可进行与运算
  两个数转换为二进制进行每位比较 同1取1 反之取0 结果不大于两个数中的最小数
- `|` `||` 或
- `!` 非
- `^` 异或 两边不一致为真 
   两边是数字进行异或运算 每二进制位进行比较 不同取1 相同取0
- `>>` 右移运算
  右移一次 就相当于该数除2(符号位不变)
- `>>>`
  不考虑符号位 并且不考虑正负数 只在最左边补`0` 负数有可能变正数
- `<<`  左移运算
  向左移动一位  删除左边(非符号位) 右边补`0` 相当于该数乘2