package sql;

import java.sql.*;

public class RS {
    public static void main(String[] args) throws Throwable {
        //第一种创建数据连接的方式
        //指定驱动程序
        Driver DRIVER = new com.mysql.cj.jdbc.Driver();
        //指定数据库连接字符串
        String URL = "jdbc:mysql://localhost:3306/test?characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";
        Connection con = null;
        //获取数据连接
        con = DriverManager.getConnection(URL, "root", "123456");
        if (con == null) {
            System.out.println("数据库连接成功");
        }
        //获取statement对象
        Statement stmt = con.createStatement();

        String sql = null;
        ResultSet rs = null;

        sql="select*from student where id=16";
        PreparedStatement Pstemt = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        rs = Pstemt.executeQuery();

        rs.moveToInsertRow();
        rs.updateString("name","李四");
        rs.updateInt("age",24);
        rs.updateString("sex","男");
        rs.updateFloat("math",76.5f);
        rs.insertRow();

        //修改记录
        rs.next();
        rs.updateString("name","王五");
        rs.updateInt("age",24);
        rs.updateString("sex","男");
        rs.updateFloat("math",78.5f);
        rs.updateRow();

        //删除记录
        rs.next();
        rs.deleteRow();

        //查询
        sql = "select*from student";
        rs = stmt.executeQuery(sql);

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
