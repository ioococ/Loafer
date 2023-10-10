# 面向对象

面向过程：侧重分步骤，考虑完成该功能的过程（自己一步一步干）
侧重分模块（找人分发任务解决任务）

**总结**
面向对象优势：可扩展，可维护，灵活性高，程序耦合度低

面向对象缺点：性能比面向过程相对较差

## 方法特点

+ 静态方法用类名调用，构造方法创建实例化时对象调用，成员方法对象调用
+ 构造方法
  + 声明：权限修饰符 方法名（参数列表）{方法体}; 方法名和类名必须一致
  + 类中没有构造方法，默认有一个无参构造，如果自己编写写但默认的就没有了，一般自己写完构造方法会再写一个无参
+ 只有成员方法才可以直接访问成员属性，静态方法不能访问成员变量（方法只要需要成员变量就定义为成员方法）
+ 成员方法可以访问静态变量

## 类和对象之间的关系
- 类：对事物客观描述的标准
- 对象：一切皆对象，符合类标准的具体个体

## 对象使用

实例化对象：`Student s1 = new Student();`

通过get和set方法获取和设置成员属性

## javaBean

`JavaBean`是一种Java语言写成的可重用组件，它是一个类（类必须是具体的公共的，并且具有无参构造器）

+ 私有化成员变量
+ 对外提供get和set方法
+ get和set方法的作用：
  + 保护成员变量
  + 进行拦截

## 实例化的内存过程
+ 加载客户端类
+ `main`方法压栈
+ 加载服务端类
+ 调用构造方法
+ 在堆内存中开辟空间，对实例化对象初始化
+ 构造方法出栈，实例化对象赋值给变量
## 异常

- 编译时异常
- 运行时异常
  - 空指针异常（用null访问成员变量时）
  - 数组下标越界

## 易错点
+ 区分成员方法和构造方法：看有**无返回值**（构造方法无返回值）
+ 对象可以调用静态变量，`javac`编译时会改成类名调用静态变量（所以空指针也不影响）
+ 静态方法不能调用成员变量

## this

对象中第一个成员变量 保存了当前对象的内存地址 不能出现在静态方法中

### 作用

+ 用在成员方法/构造方法中 区分同名的成员变量和局部变量
+ 重载调用当前类的有参构造方法
  **必须在当前构造方法方法体第一行**
+ 链式调用

## static

修饰符 用来标注静态属性 如果没有使用`static`为成员属性

### 功能

- 静态变量
- 静态方法
- 静态代码块
  不能调用 在程序加载时调用(在`main`方法之前运行) 只执行一次

代码块 无名称方法 自动调用

访问一个类的静态属性的时候 才会加载该类到内存中

实例语句块 可看做无名字成员方法

## 封装

  把所有组成部分组合到一起,还可以通过权限控制修饰符将数据隐藏起来,可以控制用户对类数据的修改程度

  适当的封装可以让代码更容易理解,易于维护,更提高了代码的安全性

### 导包

放在 `package` 之下 `class` 之上

静态导入

导入某个类的某个静态变量

### 权限控制

|    修饰符     | 同一类 | 同包  | 不同类 | 其他  |
| :-----------: | :----: | :---: | :----: | :---: |
|  **private**  |   是   |  否   |   否   |  否   |
|  **default**  |   是   |  是   |   否   |  否   |
| **protected** |   是   |  是   |   是   |  否   |
|  **public**   |   是   |  是   |   是   |  是   |

## 继承

从一个已有的类中 衍生出一个新的类 该类往往包含着父类的特征 还可以新增特有的属性

## 重写

**必须有继承关系**

- 方法名 参数列表 返回值相同
- 不能比原方法有更低的访问权限
- 不能比原方法有更宽泛的异常

### 重写重载区别

### 注解

源码注解

编译注解

运行时注解

## final

可放置在 
- 类
- 变量
- 方法

## 多态

父类引用指向子类对象

- 父类
- 引用 指向的引用数据类型
- 指向 可以找到谁
- 子类对象 创建一个子类的实例化对象

**使用父类创建的引用类型变量 可以找到子类对象**
`父类 变量名 =  new 子类();`

向上转型（由子类转换为父类） 类似于自动转换类型

**非成员方法** 

### 优点

- 降低耦合度 
- 扩展性 替换性 灵活性增强

### 缺点

丢失子类特有的属性 

**成员方法** 如果子类重写了父类的成员方法 则调用子类的成员属性

**非成员方法** 调用父类方法

```java
public class Poly {
    public static void main(String[] args) {
        Sup sub = new Sub();
        // 2
        System.out.println(sub.age);
        sub.m1();
        // Son m2
        sub.m2();
        // sub.m3();
    }
}
class Sup{
    int age = 2;
    public void m1(){
        System.out.println("Father m1");
    }
    public void m2(){
        System.out.println("Father m2");
    }
}
class Sub extends Sup{
    int age = 1;
    public void m2(){
        System.out.println("Son m2");
    }
    public void m3(){
        System.out.println("Son m3");
    }
} 
```

### instanceof

判断某个对象是否由某个类实例化而来

向下转型（由父类转换为子类）

- 直接多态
  `父类 变量名 =  new 子类();`
- 实参形参多态
- 返回值多态
  方法返回值使用父类声明

### 隐蔽多态

通过子类对象 调用继承父类的成员方法是 此时上下文环境为多态环境

```java
public class Poly_05 {
    public static void main(String[] args) {
    // Sup sup = new Sub();
    // // 2 父类
    // System.out.println(sup.age);
    // // 父类 因为子类没有
    // sup.m1();
    // // 子类 因为覆写
    // sup.m2();
    // // 报错,因为父类没有,多态会丢失子类特有属性
    // // sup.m3();
    // // 向下转型
    // Sub sub = (Sub) sup;
    // // 1 子类
    // System.out.println(sub.age);
    // // 父类 继承
    // sub.m1();
    // // 子类 因为子类有
    // sub.m2();
    // // 子类,又没有使用多态
    // sub.m3();

    Sub sub = new Sub();
    sub.m1();
    }
}

class Sup {
    int age = 2;
    public void m1() {
    /**
     * this : 是对象中第一个成员变量,保存当前对象的内存地址
     * 
     * this既然保存当前对象内存地址,那么this的类型 可以是当前类类型,可以是父类类型
     * 
     * this写在哪个类中,哪个类就是当前类 所以 当前类 是Sup 父类 是 Object
     * 
     * 因为this能调用当前类中所有的属性,并没有丢失,所以this是Sup 当前类类型
     * 
     * Sup this;
     * 
     * this : 哪个对象调用这个成员方法,this就指向谁
     * 
     * 最终是Sub调用的m1方法,所以this 指向 Sub
     * 
     * Sup this = Sub;
     */
    // System.out.println("父类m1");
    System.out.println(this);
    // 2 父类
    System.out.println(this.age);
    System.out.println(this.sakjdkashdhqwrjnfaksf);
    System.out.println(age);
    // 子类
    m2();
    // 报错
    // m3();
    }

    public void m2() {
    System.out.println("父类m2");
    }
}

class Sub extends Sup {
    int age = 1;

    public void m2() {
    System.out.println("子类m2");
    }

    public void m3() {
    System.out.println("子类m3");
    }
}
```

## abstract

修饰符 用来修饰抽象类和抽象方法

`abstract`修饰的类是抽象类 并且抽象类不能创建对象 而且抽象类一般主要用于**被继承**

abstract修饰的方法是抽象方法 该方法没有方法体 不实现功能 用于让不同的子类实现方法

抽象方法必须在抽象类中 而抽象类中可以存在普通方法

抽象类中可看作特殊的类 只不过不能创建对象

abstract和final不能同时出现