package sql.dbcp;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

public class dbcpRun {
    //加载配置文件
    //创建数据库连接池对象
    //加载数据库连接池对象
    //获取连接
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream("./src/dbcp.properties");
        properties.load(fis);
        DataSource dataSource = null;
        dataSource = BasicDataSourceFactory.createDataSource(properties); //创建连接池
        System.out.println("连接池创建成功");

        Connection conn = null;
        conn = dataSource.getConnection(); //从连接池获取连接
        if (conn != null) {
            System.out.println("连接获取成功");
            conn.close();
        } else {
            System.out.println("连接获取失败");
        }
    }
}
