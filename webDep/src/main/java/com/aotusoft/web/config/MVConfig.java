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