# IO 流

输入输出

# 四大抽象类

- 按照**处理数据类型**
  - 字节流
  - 字符流
- 按**数据流向**
  - 输入流 向内存中输入
  - 输出流 从内存中输出
- 按**功能分类**
  - 节点流
    直接操作数据流 
  - 处理流
    对其他流进行处理

# InputStream

## FileInputStream

- `public FileInputStream(String)`
  打开输入流链接 需要传入文件路径并抛出异常
- `public int reader()`
  读取下一个字节并返回对应的 ASCII 值，如果到达文件未尾返回`-1`

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
- `public int available()`
  该文件可获取的字节数

## BufferedOutputStream

# 转换流

将字节流转换为字符流

# PrintStream

打印流 为了方便操作提供了很多打印方法，用户可以把数据传递进去直接打印

`System`类中的 **标准输入输出**

`in`：标准输入，默认在控制台输入
`out`：标准输出，默认打印在控制台
`err`

在 `System` 类中提供了三个重定向标准输入/输出的方法

public static void setErr(PrintStream err) 重定向“标准”错误输出流
public static void setIn(PrintStream in) 重定向“标准”输入流
public static void setOut(PrintStream out) 重定向“标准”输出流

```java
FileOutputStream fos = new FileOutputStream("./src/test.txt");
// 包装输出流时输出操作更便捷
// 字节打印流
PrintStream ps = new PrintStream(fos);
// System 中 默认的 out 是打印在控制台，但是可以修改打印路径
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

Linux Windows 等操作系统对数据进行存储的方式不同
为了解决不同平台之间数据读取的统一性
数据流 **保证数据的一致性**

# File

- `public boolean isFile()`
  判断是否是文件
- `public boolean isDirectory()`
  判断是否是目录
- `public boolean exists()`
  判断是否存在
- `public String getAbsolutePath()`
  获取全路径（包含文件名和后缀）
- `public String getName()`
  获取文件名+后缀 a.txt
- `public String getParent()`
  获取父目录
- `public File getParentFile()`
  获取父目录文件对象
- `public File[] listFiles()`
  获取子文件对象

# 序列化

序列化：把对象保存在硬盘中，进行持久化存储
反序列化：把持久化存储的对象，载入内存中
目的：为了长期存储某个对象，便于在网络中进行传递

需要该类实现 `Serializable` 接口才能被序列化

指定版本号 可以使用`serialVersionUID`属性指定`Serializable`的版本 以验证加载的类和序列化的对象是否兼容

## transient 

关键字

限制当前属性不能被序列化，属性值不会再被保存

# 多线程

程序：一组命令的集合，为了完成指定的功能，程序是静态概念，一般保存在硬盘当中
进程：正在运行的程序，是一个动态概念，需要保存在内存当中，操作系统会分配对应的 PID，当我们直接关闭某个进程的时候 该进行会在
线程：一个程序中，不同的执行分支，如果同一个时间节点允许多个线程同时执行的时候，我们称为支持多线程
在 Java 中，`main()` 方法开始执行，就是一个线程，称为主线程

并发 一个 CPU，同时执行多个任务
并行 多个 CPU，同时执行多个任务

## 继承方式

继承 `Thread` 类 重写 `run()` 方法 就等于是新线程的 `main()` 方法

## 实现方式

实现 `Runnable` 类 重写 `run() `方法

## 继承和实现的区别

- 区别
  -	**继承 Thread**：线程代码存放 Thread 子类 `run()` 方法中。
  -	**实现 Runnable**：线程代码存在接口的子类的 `run()` 方法。
- 实现方式的好处
  - 避免了单继承的局限性
  - 多个线程可以共享同一个接口实现类的对象，非常适合多个相同线程来处理同一份资源。

**注意**

不能直接调用 `run()` 方法，否则只是方法调用而已并不会开启新线程

## 优先级

优先级默认为 5
- `public final int getPriority()`
  获得线程的优先级数值
- `public final void setPriority(int newPriority)`
  设置线程的优先级数值

## 方法

- `public final synchronized void setName(String name)`
  设置线程名称
- `public final String getName()`
  获取线程名称 名字为 Thread-0 Thread-1 ...
- `public final native boolean isAlive()`
  判断线程是否还“活”着，即线程是否还未终止。
- `public static native void sleep(long millis) throws InterruptedException`
  将当前线程睡眠指定毫秒数
- ~~`public final void stop()`~~
  停止该线程（**不推荐**），可能导致死锁状态，所以采用标识符终止
- `public final void join() throws InterruptedException`
  使两个线程合并
- `public static native void yield();`
  让出当前 CPU 时间片，让其他线程去执行
  如果拿到了 CPU 时间片，并且存在**相同优先级的线程**时，可以选择让位
- `public static native Thread currentThread()`
  返回当前正在执行的线程对象的引用

# 生命周期

**JDK 中用 `Thread.state` 类定义了线程的几种状态**

五种状态

1. 新建
   当一个 Thread 类或其子类的对象被声明并创建时，新生的线程对象处于新建状态
2. 就绪
   处于新建状态的线程被 start() 后，将进入线程队列等待 CPU 时间片，此时它已具备了运行的条件，只是没分配到 CPU 资源
3. 运行
   当就绪的线程**被调度并获得 CPU 资源**时，便进入运行状态，run() 方法定义了线程的操作和功能
4. 阻塞
5. 在某种特殊情况下，被**人为挂起**或**执行输入输出操作**时，让出 CPU 并临时中止自己的执行，进入阻塞状态
6. 死亡
   线程完成了它的全部工作或线程被提前强制性地中止或出现异常导致结束

# 线程同步

**多个线程执行的不确定性引起执行结果的不稳定**

线程同步：当多个线程有可能同时操作同一个数据的时候，为了保证数据一致性，需要进行同步执行
本质是同步数据，是一种安全机制
异步编程：线程之间是完全独立的，相互没有影响
同步编程：线程之间不是完全独立的，相互可能有影响

# 线程锁

## 方法锁

synchronized：方法加锁
当某线程访问某个对象中加 synchronized 修饰的成员方法时，则该对象中所有加 synchronized 修饰的成员方法全部锁定
此时任何线程均不能访问 synchronized 修饰的成员方法，需排队当上一个线程执行完方法后交出锁，此时其他线程才可以去访问

缺点：效率低。需要排队执行，并且整个对象中所有加锁的成员方法全部锁定
优点：数据的安全性和一致性有所保障，避免出现数据错误

# 语句块锁

## 类锁

静态也可以加锁 称为类锁
所有加锁的静态方法和静态语句块锁全部锁定 `Synchronized(类名.class){}`

## 对象锁

成员 也可以加锁，称为**对象锁**
该对象中，所有加锁的成员方法和成员语句块锁全部锁定 `Synchronized (对象){}`（不同对象直接不会影响）

# Lock 锁

- 从 JDK 5.0 开始，Java 提供了更强大的线程同步机制——通过显式定义同步锁对象来实现同步。同步锁使用 Lock 对象充当。
- `java.util.concurrent.locks.Lock` 接口是控制多个线程对共享资源进行访问的工具。锁提供了对共享资源的独占访问，每次只能有一个线程对 Lock 对象 加锁，线程开始访问共享资源之前应先获得 Lock 对象。
- ReentrantLock 类实现了 Lock ，它拥有与 synchronized 相同的并发性和内存语义，在实现线程安全的控制中，比较常用的是 ReentrantLock，可以显式加锁、释放锁。

lock 是显式锁，需要手动开启和关闭
synchronized 是隐式锁，自动开启，执行完自动关闭
lock 只有代码块锁，而 synchronized 支持方法和代码块锁
lock 锁，需要 JVM 花费较少的时间来进行资源调度。性能相对较好，而有很好的扩展性
使用顺序 : Lock 锁 --> 同步代码块锁 --> 方法锁

# 定时器任务

定时器：计划任务
只要有一个计划任务就会开启一个线程，进行计时，到达指定时间后由该线程来完成这个任务

## 方法

- `public void schedule(TimerTask task, long delay, long period)`
- `public void schedule(TimerTask task, long delay)`

```java
public class MyTimerTest {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new MyTimer(), 1000, 500);
    }
}

class MyTimer extends TimerTask {

    @Override
    public void run() {
        System.out.println("run() 方法执行");
    }
}
```

# 守护线程

每个程序运行时，都会有一个守护线程同步启动，用于监听我们的正常程序
当主线程执行完之后，守护线程也就没有存在的价值了，因为没有工作可做，此时JVM 就会关机，守护线程终止
我们可以通过 `线程对象.setDaemon(true)` 来把某个线程设置为守护线程（必须在启动之前设置）  

# 死锁

在程序执行过程中，都遇到了**对方进入加锁的方法中**导致大家都访问不了

原理 :

1. 某个线程执行完成，需要**先后嵌套锁定执行**两个对象，同时在这个过程中先锁定第一个对象，再锁定第二个对象
2. 另外一个线程执行完成，需要 先后 嵌套 锁定 执行两个对象，同时在这个过程中，先锁定第二个对象，再锁定第一个对象
3. 在第一个线程，锁定第一个对象后，要去锁定第二个对象时，发现第二个对象已经被锁定，只能等待
4. 第二个线程，锁定第二个对象后要去锁定第一个对象时，发现第一个对象已经被锁定，只能等待

# 线程通信

Object 中的方法

- wait() ： 让该线程进入等待状态（挂起状态）, 当被唤醒后进入就绪状态，然后继续执行之前挂起的地方

无参 或 传入参数 `0`  都表示不会自动唤醒，只能被叫醒 (`notify(),notifyAll()`)

- notify() : 随机唤醒一个在该对象上等待的一个条线程让其他线程去执行
- notifyAll() : 唤醒所有在该对象上等待的线程

也可以传入 long 类型的毫秒数，到指定毫秒数之后自动唤醒
wait 和 sleep 的区别 : sleep 不会交出锁，依然占用锁，其他线程无法进入，wait 会交出锁，其他线程可以进去
以上方法必须用在成员方法中且该方法必须加锁 (synchronized)

