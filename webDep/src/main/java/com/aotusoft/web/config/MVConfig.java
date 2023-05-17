package com.aotusoft.web.config;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

public class MVConfig implements WebMvcConfigurer {
    //public interface ViewResolver {} 实现了视图解析器接口的类就可以被称为视图解析器

    public static class VResolver implements ViewResolver{

        @Override
        public View resolveViewName(String viewName, Locale locale) throws Exception {
            return null;
        }
    }
}
