package sql.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class c3p0Run {
    public static void main(String[] args) throws PropertyVetoException, SQLException {
        // 通过set方法配置数据库连接池
        //  创建数据库连接池对象
        //  定义Connection数据库连接变量
        //  使用连接池的set方法对连接池进行配置
        //  获取连接



        //定义数据库连接池对象
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        Connection conn = null;

        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test?characterEncoding=utf-8&useSSL=false&serverTimezone=UTC");
        dataSource.setUser("root");
        dataSource.setPassword("123456");
        dataSource.setInitialPoolSize(10);//初始连接数
        dataSource.setMaxPoolSize(30);//最大连接数
        dataSource.setMinPoolSize(5);//最小连接数
        dataSource.setAcquireIncrement(1);//增加数

        //通过连接池获取连接
        conn = dataSource.getConnection();
        System.out.println("获取数据库连接成功");

        if (conn != null) {
            conn.close();
        }
        // dataSource.close();
    }
}
