package sql.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Xmlc3p0Run {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //方法三用c3p0-config. xmL文件来进行配置
        //  先配置c3p0-config . xmL文件
        //  将文件放在src目录下面
        //  定义ComboPooledDataSource对象
        //  定义Connection变量
        //  指定数据库驱动
        //  创建ComboPooLedDataSource对象
        //  创建Connection对象
        ComboPooledDataSource dataSource = null;
        Connection conn = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dataSource = new ComboPooledDataSource("mysql");
        conn = dataSource.getConnection();
        System.out.println("获取数据库连接成功");

    }
}
