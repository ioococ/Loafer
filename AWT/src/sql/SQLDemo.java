package sql;

import java.sql.*;

public class SQLDemo {
    //第一种创建数据连接的方式

    //指定驱动程序
    static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    //指定数据库连接字符串
    static final String URL = "jdbc:mysql://localhost:3306/RUNOOB?characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";

    static final String USER = "root";
    static final String PASS = "123456";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("连接数据库...");
        try {
            conn = DriverManager.getConnection(URL, USER, PASS);

            System.out.println("实例化Statement对象...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT id, name, url FROM websites";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String url = rs.getString("url");

                System.out.print("ID: " + id);
                System.out.print(", 站点名称: " + name);
                System.out.print(", 站点 URL: " + url);
                System.out.print("\n");
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
















