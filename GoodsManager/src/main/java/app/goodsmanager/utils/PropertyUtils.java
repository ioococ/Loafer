package app.goodsmanager.utils;

import java.io.IOException;
import java.util.Properties;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 2023/11/10 14:52 星期五
 */

public class PropertyUtils {
    private static final Properties properties = new Properties();

    public static String get(String key) {
        try {
            properties.load(PropertyUtils.class.getClassLoader().getResourceAsStream("jdbc.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return properties.getProperty(key);
    }
}
