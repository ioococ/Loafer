# Exception

Exception 是所有异常类的父类

printStackTrace() 打印错误的追踪栈帧
getMessage() 获取错误信息

# try catch

处理异常

1.7 新特性 自动关闭资源

```java
try(资源打开语句;可以写多个){
  高风险语句
} catch(异常类型){

}
```

可以写多个catch 但是从上到下必须是从子类到父类 或者没有继承关系

# throws

抛出异常  提醒机制

# fianlly

必须执行的语句块 不能单独使用 必须和try try...catch一同使用

只有在执行System.exit(0)后finally才不会执行

# 不能有比原方法有更宽泛的异常

# 自定义异常

一般需要提供无参构造以及有参构造 用于把异常信息传递给父类

## throw

异常起点