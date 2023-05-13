#### 配置文件

以下配置文件方式存在优先级
1.  `file:./config/`
2.  `file:./`
3.  `classpath:/config/`
4.  `classpath:/`

使用 `spring.config.location`, 配置自定义配置路径
1.  `file:./custom-config/`
2.  `classpath:custom-config/`

### 配置绑定

可配置项 存在一个固有的规律

可配置的项存在于`spring-boot-autoconfigure`jar包,`spring.factories` 里的`xxxProperties`类 被`xxxAutoConfiguration`类装配

`xxxProperties`又跟配置文件绑定

### `@Conditional`注解

`@conditional注解`是SpringBoot starter的基石，自动装配的时候会根据条件确定是否需要注入这个类。

含义：基于条件的注解。

作用：根据是否满足某个特定条件来决定是否创建某个特定的Bean。

意义：SpringBoot实现自动配置的关键基础能力。

[@Conditional相关注解](https://www.jianshu.com/p/b57b79eeaf95)

@ConditionalOnBean:仅仅在当前上下文中存在某个对象时，才会实例化一个Bean  
@ConditionalOnClass:某个class位于类路径上才会实例化一个Bean  
@ConditionalOnExpression:当表达式为true的时候，才会实例化一个Bean  
@ConditionalOnMissingBean:仅仅在当前上下文中不存在某个对象时，才会实例化一个Bean  
@ConditionalOnMissingClass:某个class不位于类路径上才会实例化一个Bean  
@ConditionalOnNotWebApplication:不是web应用

例如:

**配置文件有这个配置**

```java
spring.data.mongodb.uri=mongodb://paopaoedu:paopaoedu@localhost:27017/paopaoedu
```

判断有这个配置才注入这个类 

```java
package com.paopaoedu.springboot.condition; 
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component; 
@Component
@ConditionalOnProperty("spring.data.mongodb.uri")
public class ConditionalTest {}
```