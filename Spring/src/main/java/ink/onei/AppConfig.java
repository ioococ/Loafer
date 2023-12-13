package ink.onei;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author: nekotako
 * @Description: Configuration
 * @Date: 13/12/2023 11:03 Wednesday
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Configuration
@ComponentScan(basePackages = "ink.onei.*")
@PropertySource("jdbc.properties")
public class AppConfig {
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

}
