package sql;

import java.sql.*;

public class SQLifilter {
    public static void main(String[] args) throws Throwable {
        //第一种创建数据连接的方式
        //指定驱动程序
        /*String DRIVER = "com.mysql.cj.jdbc.Driver";*/
        Driver DRIVER = new com.mysql.cj.jdbc.Driver();
        //指定数据库连接字符串
        String URL = "jdbc:mysql://localhost:3306/test?characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";
        Connection con = null;
        //加载驱动程序
        /*Class.forName(DRIVER);*/
        //获取数据连接
        con = DriverManager.getConnection(URL, "root", "123456");
        if (con == null) {
            System.out.println("数据库连接成功");
        }
        //获取statement对象
        Statement stmt = con.createStatement();
        //使用statement对象执行sql语句
        String sql = null;


        String vName = "马云";
        String vEnglish = "100";

        String vPassword = "11 OR 1=1";

        sql = "select*from student where name ="+vName+"and id="+vPassword;
        String sql1 = "select*from student where name = '马云' and id=11";
        String sql2= "select*from student where name = '马云' or 1=1";
        //sql = "select*from student where name =? and id=?";

        sql = "update student set english=? where name=?";
        PreparedStatement Pstmt = con.prepareStatement(sql);
        //Pstmt.setString(1,vName);
        //Pstmt.setString(2,vPassword);

        Pstmt.setString(1,vEnglish);
        Pstmt.setString(2,vName);

        Pstmt.executeUpdate();

        sql = "select*from student";
        ResultSet rs = stmt.executeQuery(sql);

        //操作结果集
        if (rs != null) {
            ResultSetMetaData rsmd = rs.getMetaData();
            int countcols = rsmd.getColumnCount();
            for (int i = 1; i <= countcols; i++) {
                if (i > 1) System.out.print("\t");
                System.out.print(rsmd.getColumnName(i) + "\t");
            }
            //显示结果集
            System.out.println();
            rs.beforeFirst();
            while (rs.next()) {
                if (rs.getString("name").length() == 2) {
                    System.out.print(rs.getString("name") + "\t\t");
                } else {
                    System.out.print(rs.getString("name") + "\t");
                }
                System.out.print(rs.getString("age") + "\t\t");
                System.out.print(rs.getString("sex") + "\t\t");
                System.out.print(rs.getString("address") + "\t\t\t");
                System.out.print(rs.getString("math") + "\t\t");
                System.out.print(rs.getString("english") + "\t\t");
                System.out.println();
            }
        }
        System.out.println("完成");

        rs.close();
        stmt.close();
        con.close();
    }
}
