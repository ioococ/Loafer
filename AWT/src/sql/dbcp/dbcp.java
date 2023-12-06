package sql.dbcp;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class dbcp {
    public static void main(String[] args) throws SQLException {
        /*
         * 1.建立配置文件
         * 2.加载配置文件
         * 3.创建数据库连接池对象
         * 4.获取链接
         * */
        Properties properties=new Properties();//创建文件操作对象
        try {
            //创建输入流
            FileInputStream is=new FileInputStream("./src/dbcp.properties");
            //加载配置文件
            properties.load(is);
        }catch (Exception e){
            System.out.println("配置文件失败");
            e.printStackTrace();
            System.exit(0);
        }
        //定义连接池对象变量
        DataSource dataSource=null;
        try {
            dataSource= BasicDataSourceFactory.createDataSource(properties);//创建连接池对象
            System.out.println("连接池创建成功!");
        }catch (Exception e){
            System.out.println("连接池创建失败");
            e.printStackTrace();
            System.exit(0);
        }
        //获取链接
        Connection conn=null;
        try {
            conn=dataSource.getConnection();//从连接池获取数据库连接
            if (conn!=null){
                System.out.println("获取连接成功");
            }else {
                System.out.println("连接获取失败");
            }
        }catch (Exception e){
            System.out.println("发生异常，获取链接失败");
            e.printStackTrace();
            System.exit(0);
        }
        ///
        //这里放针对数据库进行操作的代码
        if (conn!=null){
            conn.close();

        }
    }
}
