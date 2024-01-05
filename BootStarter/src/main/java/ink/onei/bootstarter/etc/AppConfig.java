package ink.onei.bootstarter.etc;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 05/01/2024 17:45 Friday
 */

@Configuration
public class AppConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/**").excludePathPatterns("/login","/api/AjaxLogin","/static/**");
    }
}
