package ink.onei.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author: nekotako
 * @Description: 数据库操作工具类
 * @Date: 2023/11/10 14:51 星期五
 */

public class DBUtils {
    public static Connection getConnection() {
        XBasicDataSource dataSource = new XBasicDataSource();
        dataSource.setDriverClassName(PropertyUtils.get("driver"));
        dataSource.setUrl(PropertyUtils.get("url"));
        dataSource.setUsername(PropertyUtils.get("username"));
        dataSource.setPassword(PropertyUtils.get("password"));
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean close(ResultSet resultSet, Statement statement, Connection connection) {
        try {
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
    public static boolean close(Statement statement, Connection connection) {
        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
