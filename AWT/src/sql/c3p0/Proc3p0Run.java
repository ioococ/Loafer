package sql.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class Proc3p0Run {
    public static void main(String[] args) throws IOException, PropertyVetoException, SQLException {
        //通过属性文件配置数据库连接池
        //  创建数据库连接池对象
        //  定义Connection数据库连接变量
        //  配置属性文件
        //  加载属性文件
        //  创建ComboPooledDataSource对象
        //  获取连接

        //加载配置文件
        Properties prop = new Properties();
        InputStream is = new FileInputStream("./src/c3p0.properties");//创建输入流
        prop.load(is);

        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(prop.getProperty("DriverClass"));
        dataSource.setJdbcUrl(prop.getProperty("JdbcUrl"));
        dataSource.setUser(prop.getProperty("User"));
        dataSource.setPassword(prop.getProperty("Password"));
        dataSource.setMaxPoolSize(Integer.parseInt(prop.getProperty("MaxPoolSize")));
        dataSource.setMinPoolSize(Integer.parseInt(prop.getProperty("MinPoolSize")));
        dataSource.setInitialPoolSize(Integer.parseInt(prop.getProperty("InitialPoolSize")));
        dataSource.setMaxStatements(Integer.parseInt(prop.getProperty("MaxStatements")));
        dataSource.setMaxIdleTime(Integer.parseInt(prop.getProperty("MaxIdleTime")));
        System.out.println("连接池配置成功");

        Connection conn = dataSource.getConnection();
        System.out.println("获取数据库连接成功");


/*        if (conn != null) {
            conn.close();
        }*/
    }
}
