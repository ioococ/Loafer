package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @Author: nekotako
 * @Description: 查询student_info表所有学生信息并输出
 * @Date: 2023/11/13 19:27 星期一
 */

public class Query {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");
        Statement stmt = conn.createStatement();
        ResultSet resultSet = stmt.executeQuery("select * from student_info");
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1) +
                    "\t" + resultSet.getString(2) +
                    "\t" + resultSet.getString(3) +
                    "\t" + resultSet.getString(4) +
                    "\t" + resultSet.getString(5) +
                    "\t" + resultSet.getString(6));
        }
    }
}
