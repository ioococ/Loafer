优先级1：项目路径下的config文件夹配置文件
优先级2：项目路径下配置文件
优先级3：资源路径下的config文件夹配置文件
优先级4：资源路径下配置文件

以下配置文件方式存在优先级
1.  `file:./config/`
2.  `file:./`
3.  `classpath:/config/`
4.  `classpath:/`

使用 `spring.config.location`, 配置自定义配置路径
1.  `file:./custom-config/`
2.  `classpath:custom-config/`

