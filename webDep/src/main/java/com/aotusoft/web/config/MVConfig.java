package com.aotusoft.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//@EnableWebMvc
/*
 * @EnableWebMvc注解导入了DelegatingWebMvcConfiguration类
 * 而DelegatingWebMvcConfiguration类继承了WebMvcConfigurationSupport类
 * 且WebMvcAutoConfiguration类中存在@ConditionalOnMissingBean({WebMvcConfigurationSupport.class})注解
 * 所以当WebMvcConfigurationSupport存在时WebMvcAutoConfiguration将不会生效
* */

//扩展SpringMVC
@Configuration
public class MVConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        WebMvcConfigurer.super.addViewControllers(registry);
        registry.addViewController("/aotusoft").setViewName("test");
    }
}
