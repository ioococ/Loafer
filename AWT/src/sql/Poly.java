package sql;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class Poly {
    public static void main(String[] args) throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        Connection conn = null;

        Scanner input = new Scanner(System.in);
        System.out.println("1、普通方法 2、Properties 方法 3、Xml 方法");
        System.out.print("请输入选择：");
        int x = input.nextInt();
        if (x == 1) {
            simC3p0(dataSource, conn);
        } else if (x == 2) {
            ProcC3p0(dataSource, conn);
        } else if (x == 3) {
            XmlC3p0(dataSource, conn);
        } else {
            System.exit(0);
        }

        if (conn != null) {
            conn.close();
        }
    }

    static void simC3p0(ComboPooledDataSource dataSource, Connection conn) throws PropertyVetoException, SQLException {
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test?characterEncoding=utf-8&useSSL=false&serverTimezone=UTC");
        dataSource.setUser("root");
        dataSource.setPassword("123456");
        dataSource.setInitialPoolSize(10);
        dataSource.setMaxIdleTime(30);
        dataSource.setMinPoolSize(5);
        dataSource.setAcquireIncrement(1);
        System.out.println("连接池配置成功");

        conn = dataSource.getConnection();
        System.out.println("获取数据库连接成功");
    }

    static void ProcC3p0(ComboPooledDataSource dataSource, Connection conn) throws IOException, PropertyVetoException, SQLException {
        Properties prop = new Properties();
        InputStream is = new FileInputStream("./src/c3p0.properties");
        prop.load(is);

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

        conn = dataSource.getConnection();
        System.out.println("获取数据库连接成功");
    }

    static void XmlC3p0(ComboPooledDataSource dataSource, Connection conn) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        dataSource = new ComboPooledDataSource("mysql");
        System.out.println("连接池配置成功");

        conn = dataSource.getConnection();
        System.out.println("获取数据库连接成功");
    }
}