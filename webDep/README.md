## 静态资源映射规则

**首先，我们搭建一个普通的SpringBoot项目，回顾一下HelloWorld程序！**

写请求非常简单，那我们要引入我们前端资源，我们项目中有许多的静态资源，比如css，js等文件，这个SpringBoot怎么处理呢？

如果我们是一个web应用，我们的main下会有一个webapp，我们以前都是将所有的页面导在这里面的，对吧！但是我们现在的pom呢，打包方式是为jar的方式，那么这种方式SpringBoot能不能来给我们写页面呢？当然是可以的，但是SpringBoot对于静态资源放置的位置，是有规定的！

**我们先来聊聊这个静态资源映射规则：**

SpringBoot中，SpringMVC的web配置都在 WebMvcAutoConfiguration 这个配置类里面；

我们可以去看看 WebMvcAutoConfigurationAdapter 中有很多配置方法；

有一个方法：addResourceHandlers 添加资源处理

```java
@Override
public void addResourceHandlers(ResourceHandlerRegistry registry){
        if(!this.resourceProperties.isAddMappings()){
        // 已禁用默认资源处理
        logger.debug("Default resource handling disabled");
        return;
        }
        // 缓存控制
        Duration cachePeriod=this.resourceProperties.getCache().getPeriod();
        CacheControl cacheControl=this.resourceProperties.getCache().getCachecontrol().toHttpCacheControl();
        // webjars 配置
        if(!registry.hasMappingForPattern("/webjars/**")){
        customizeResourceHandlerRegistration(registry.addResourceHandler("/webjars/**")
        .addResourceLocations("classpath:/META-INF/resources/webjars/")
        .setCachePeriod(getSeconds(cachePeriod)).setCacheControl(cacheControl));
        }
        // 静态资源配置
        String staticPathPattern=this.mvcProperties.getStaticPathPattern();
        if(!registry.hasMappingForPattern(staticPathPattern)){
        customizeResourceHandlerRegistration(registry.addResourceHandler(staticPathPattern)
        .addResourceLocations(getResourceLocations(this.resourceProperties.getStaticLocations()))
        .setCachePeriod(getSeconds(cachePeriod)).setCacheControl(cacheControl));
        }
        }
```

读一下源代码：比如所有的 /webjars/\*\* ， 都需要去 classpath:/META-INF/resources/webjars/ 找对应的资源；

## 什么是webjars 呢？

Webjars本质就是以jar包的方式引入我们的静态资源 ， 我们以前要导入一个静态资源文件，直接导入即可。

使用SpringBoot需要使用Webjars，我们可以去搜索一下：

网站：https://www.webjars.org

要使用jQuery，我们只要要引入jQuery对应版本的pom依赖即可！

```xml
<dependency>
    <groupId>org.webjars</groupId>
    <artifactId>jquery</artifactId>
    <version>3.4.1</version>
</dependency>
```

第二种静态资源映射规则
那我们项目中要是使用自己的静态资源该怎么导入呢？我们看下一行代码；

我们去找staticPathPattern发现第二种映射规则 ：/** , 访问当前的项目任意资源，它会去找 resourceProperties 这个类，我们可以点进去看一下分析：

```java
// 进入方法

// 进入方法
public String[]getStaticLocations(){
        return this.staticLocations;
        }
// 找到对应的值
private String[]staticLocations=CLASSPATH_RESOURCE_LOCATIONS;
// 找到路径
private static final String[]CLASSPATH_RESOURCE_LOCATIONS={
        "classpath:/META-INF/resources/",
        "classpath:/resources/",
        "classpath:/static/",
        "classpath:/public/"
        };
```

ResourceProperties 可以设置和我们静态资源有关的参数；这里面指向了它会去寻找资源的文件夹，即上面数组的内容。

所以得出结论，以下四个目录存放的静态资源可以被我们识别：

```
"classpath:/META-INF/resources/"
"classpath:/resources/"
"classpath:/static/"
"classpath:/public/"
```

我们可以在resources根目录下新建对应的文件夹，都可以存放我们的静态文件；

比如我们访问 http://localhost:8080/1.js , 他就会去这些文件夹中寻找对应的静态资源文件；

## 自定义静态资源路径

我们也可以自己通过配置文件来指定一下，哪些文件夹是需要我们放静态资源文件的，在application.properties中配置；

```
spring.resources.static-locations=classpath:/coding/,classpath:/aotusoft/
```

一旦自己定义了静态文件夹的路径，原来的自动配置就都会失效了！


`ContentNegotiatingViewResolver`实现`ViewResolver`视图解析器接口,是一个视图解析器类
```java
public class ContentNegotiatingViewResolver extends WebApplicationObjectSupport implements ViewResolver, Ordered, InitializingBean {}
```
实现方法:
```java
    @Nullable
    public View resolveViewName(String viewName, Locale locale) throws Exception {
        RequestAttributes attrs = RequestContextHolder.getRequestAttributes();
        Assert.state(attrs instanceof ServletRequestAttributes, "No current ServletRequestAttributes");
        List<MediaType> requestedMediaTypes = this.getMediaTypes(((ServletRequestAttributes)attrs).getRequest());
        if (requestedMediaTypes != null) {
            //getCandidateViews获取候选视图
            List<View> candidateViews = this.getCandidateViews(viewName, locale, requestedMediaTypes);
            //getBestView得到最好的视图
            View bestView = this.getBestView(candidateViews, requestedMediaTypes, attrs);
            if (bestView != null) {
                return bestView;
            }
        }

        String mediaTypeInfo = this.logger.isDebugEnabled() && requestedMediaTypes != null ? " given " + requestedMediaTypes.toString() : "";
        if (this.useNotAcceptableStatusCode) {
            if (this.logger.isDebugEnabled()) {
                this.logger.debug("Using 406 NOT_ACCEPTABLE" + mediaTypeInfo);
            }

            return NOT_ACCEPTABLE_VIEW;
        } else {
            this.logger.debug("View remains unresolved" + mediaTypeInfo);
            return null;
        }
    }
```


```java
package com.aotusoft.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

@Configuration
public class MVConfig implements WebMvcConfigurer {
    //public interface ViewResolver {} 实现了视图解析器接口的类就可以被称为视图解析器

    @Bean
    public ViewResolver myViewResolver(){
        return new VResolver();
    }
    //自定义自己的视图解析器ViewResolver
    public static class VResolver implements ViewResolver{
        @Override
        public View resolveViewName(String viewName, Locale locale) throws Exception {
            return null;
        }
    }
}

```