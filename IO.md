# IO 流

输入输出

# 四大抽象类

- 按照处理数据类型
  - 字节流
  - 字符流
- 按数据流向
  - 输入流 向内存中输入
  - 输出流 从内存中输出
- 按功能不同
  - 节点流
    直接操作数据流 
  - 处理流
    对其他流进行处理

# InputStream

## FileInputStream

- `public FileInputStream(String)`
  打开输入流链接 需要传入文件路径并抛出异常
- `public int reader()`
  读取下一个字节并返回对应的ASCII值，如果到达文件未尾返回`-1`

# OutputStream

## FileOutputStream

- `public FileOutputStream(String)`
  打开流链接 需要传入文件路径并抛出异常 覆盖写入
- `public FileOutputStream(String,Boolean)`
  打开流链接 需要传入文件路径并抛出异常 为`true`时是追加写入
- `public void write()`
  - `public void write(byte[])`
  - `public void write(byte[],int,int)`
- `public void flush()`
- `public void append()`

# Reader

## FileReader

字符输入流 每次读取一个字符，可以避免汉字乱码问题主要适用于纯文本文件

# Writer

## FileWriter

- `public void write()`
  - `public void write(char[])`
  - `public void write(char[],int,int)`
  - `public void write(String)`
  - `public void write(String,int,int)`
- `public void flush()`
- `public void append()`

# 节点处理流

需要传入节点流（FileInputStream、FileOutputStream、FileReader、FileWriter）进行处理

# 缓冲流

## BufferedReader
## BufferedWriter

## BufferedInputStream

- `public String readLine()`
  返回此次读到的数据，如果到达文件未尾返回`null`，不读取换行符

## BufferedOutputStream

# 转换流

将字节流转换为字符流

# PrintStream

打印流 为了方便操作提供了很多打印方法,用户可以把数据传递进去直接打印


`System`类中的 **标准输入输出**

`in`：标准输入，默认在控制台输入
`out`：标准输出，默认打印在控制台
`err`

在 `System` 类中提供了三个重定向标准输入/输出的方法

static void setErr(PrintStream err) 重定向“标准”错误输出流
static void setIn(PrintStream in) 重定向“标准”输入流
static void setOut(PrintStream out) 重定向“标准”输出流

```java
FileOutputStream fos = new FileOutputStream("./src/test.txt");
// 包装输出流时输出操作更便捷
// 字节打印流
PrintStream ps = new PrintStream(fos);
// System中 默认的out 是打印在控制台,但是可以修改打印路径
System.setOut(ps);
System.out.println("===============");
```

## 特点

- 打印流是输出最方便的类
- 包含字节打印流 `PrintStream`，字符打印流 `PrintWriter`
- `PrintStream` 是 OutputStream 的子类，把一个输出流的实例传递到打印流之后，可以更加方便地输出内容，相当于把输出流重新包装一下
- `PrintStream` 类的 `print()`方法被重载很多次 `print(int i)`、`print(boolean b)`、`print(char c)`

## PrintWriter

字符打印流
- `public void println()`

# DataInputStream

Linux Windows等操作系统对数据进行存储的方式不同
为了解决不同平台之间数据读取的统一性
数据流 **保证数据的一致性**

