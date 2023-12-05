package sql.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class SB {
    public static void main(String[] args) throws SQLException {
        /*
         * 通过set方法来配置数据库连接池
         * 创建connection数据库连接变量
         * 配置属性文件
         * 加载属性文件
         * 创建combopooledDatasource对象
         * 获取连接
         * */

//        //1.定义数据库连接池对象
//        ComboPooledDataSource dataSource = new ComboPooledDataSource();
//        Connection conn = null;
//        //2.配置连接池对象
//        try {
//            dataSource.setDriverClass("com.mysql.jdbc.Driver");
//            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/sys?characterEncoding=utf-8&useSSL=false&serverTimezone=UTC");
//            dataSource.setUser("root");
//            dataSource .setPassword("zhuzhu12345");
//            dataSource.setInitialPoolSize(10);//初始连接数
//            dataSource.setMaxPoolSize(30);//最大连接数
//            dataSource.setMinPoolSize(5);//最小连接数
//            dataSource.setAcquireIncrement(1);//增加数
//            System.out.println("配置连接池成功");
//        }catch (Exception e){
//            System.out.println("配置连接池失败");
//            e.printStackTrace();
//            System.exit(0);
//        }
//        //3.通过连接池获取连接
//        try {
//            conn = dataSource.getConnection();
//            System.out.println("获取数据库连接成功");
//        }catch (Exception e){
//            System.out.println("获取数据库连接失败");
//            e.printStackTrace();
//            System.exit(0);
//        }
//
//        /*
//        * 这里可以写数据库操作的代码
//        * 增删改查
//        *
//        * */
//        //关闭连接   此处的关闭是将连接交还了连接池
//        if(conn!=null){
//            conn.close();
//        }


        /*
         * 方法二 通过 .properties 文件配置数据库连接池
         * 1.定义连接池 combPooledDataSource 的变量
         * 2.定义Connection变量
         * 3.配置c3p0.properties文件
         * 4.加载properties文件
         * 5.创建combopooledDataSource对象
         * 6.加载配置文件中的配置
         * 7.创建数据库连接
         * */
        ComboPooledDataSource dataSource = null;
        Connection conn = null;
        //配置c3p0连接池
        try{
            Properties props = new Properties();//创建.properties 文件操作对象
            InputStream is = new FileInputStream("./src/c3p0.properties");//创建输入流
            props.load(is);

            dataSource = new ComboPooledDataSource();//创建连接池对象
            dataSource.setDriverClass(props.getProperty("DriverClass"));
            dataSource.setJdbcUrl(props.getProperty("JdbcUrl"));
            dataSource.setUser(props.getProperty("User"));
            dataSource.setPassword(props.getProperty("Password"));
            dataSource.setMaxPoolSize(Integer.parseInt(props.getProperty("MaxPoolSize")));
            dataSource.setMinPoolSize(Integer.parseInt(props.getProperty("MinPoolSize")));
            dataSource.setInitialPoolSize(Integer.parseInt(props.getProperty("InitialPoolSize")));
            dataSource.setMaxStatements(Integer.parseInt(props.getProperty("MaxStatements")));
            dataSource.setMaxIdleTime(Integer.parseInt(props.getProperty("MaxIdleTime")));
            System.out.println("连接池配置成功");
        }catch (Exception e){
            System.out.println("连接池配置失败");
            e.printStackTrace();
            System.exit(0);
        }
        try {
            conn = dataSource.getConnection();
            System.out.println("获取连接成功");
        }catch (Exception e){
            System.out.println("获取连接失败");
            e.printStackTrace();
        }
    }
}

