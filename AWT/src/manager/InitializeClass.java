package manager;

import java.io.File;
import java.io.IOException;
import java.sql.*;

public class InitializeClass {
    public String driver = "com.mysql.cj.jdbc.Driver";
    public String URL = "jdbc:mysql://localhost:3306/manager?characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";
    public String user = "root";
    public String password = "123456";

    public static String sql = null; //sql字串
    public static Connection conn = null; //连接对象
    public static Statement stmt = null; //SQL语句执行对象
    public static ResultSet rs = null; //结果集对象
    public static Object[] Param = null; //给sql语句传参数用

    public Object[] getParam () {
        return Param;
    }

    public void setParam (Object[] param) {
        Param = param;
    }

    public void getConnection() {
        //1.获取连接的方法
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection(URL,user,password);
            System.out.println("数据库连接成功");
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        File file = new File("C:\\Users\\荣耀\\eclipse-workspace\\AWT\\src\\manager\\initialize");
        if (file.exists()) {
            System.out.println("初始化成功");
        } else {
            initialize(stmt);
        }
    }
    public void initialize (Statement stmt) {
        sql = "create table if not exists userTable(ID int(4) primary key auto_increment,username varchar(20),password varchar(10),createuser varchar(10),createdate date)";
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("用户表创建成功");

        sql = "create table if not exists inputTable(ID int(4) primary key auto_increment,bh varchar(16),name varchar(30),num int(4),jhr varchar(8),createdate date,jsr varchar(8))";
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("入库流水表创建成功");

        sql = "create table if not exists outputTable(ID int(4) primary key auto_increment,bh varchar(16),name varchar(30),num int(4),jhr varchar(8),createdate date,KgName varchar(8))";
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("出库流水表创建成功");

        sql = "create table if not exists currentTable(ID int(4) primary key auto_increment,bh varchar(16),name varchar(30),num int(4))";
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("即时库存表创建成功");

        sql = "insert into userTable(username,password) values('su','root')";
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("用户创建成功");
        File file = new File("C:\\Users\\荣耀\\eclipse-workspace\\AWT\\src\\manager\\initialize");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("初始化完成");
    }

    public void execSql (String sql, Statement stmt) {
        try {
            stmt.executeUpdate(sql);
            stmt.executeUpdate("flush privileges");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
