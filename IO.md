# IO 流

输入输出

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

# FileInputStream

- `public FileInputStream(String)`
  打开输入流链接 需要传入文件路径并抛出异常
- `public int reader()`
  读取下一个字节并返回对应的ASCII值 如果到达文件未尾返回`-1`

# OutputStream

# FileOutputStream

- `public FileOutputStream(String)`
  打开流链接 需要传入文件路径并抛出异常 覆盖写入
- `public FileOutputStream(String,Boolean)`
  打开流链接 需要传入文件路径并抛出异常 为`true`时是追加写入
- `public void write()`
  - `public void write(byte[])`
  - `public void write(byte[],int,int)`
- `public void flush()`
- `public void append()`

# FileReader

字符输入流 每次读取一个字符，可以避免汉字乱码问题主要适用于纯文本文件

# FileWriter

- `public void write()`
  - `public void write(char[])`
  - `public void write(char[],int,int)`
  - `public void write(String)`
  - `public void write(String,int,int)`
- `public void flush()`
- `public void append()`