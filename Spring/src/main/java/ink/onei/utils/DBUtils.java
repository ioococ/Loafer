package ink.onei.utils;

import ink.onei.AppConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @Author: nekotako
 * @Description: 数据库工具类
 * @Date: 13/12/2023 18:41 Wednesday
 */
@Component
public class DBUtils {
    @Bean
    public Connection getConnection(AppConfig config) {
        try {
            Class.forName(config.getDriver());
            return DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
