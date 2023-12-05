package sql.daoproject.dao;


import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dao {
    // 连接数据库四要点
    private String driver="com.mysql.cj.jdbc.Driver";
    private String URL = "jdbc:mysql://localhost:3306/test?characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";
    private String user = "root";
    private final String password = "123456";

    private String sql = null;
    private Connection conn = null; //连接对象
    private PreparedStatement Pstmt = null; // SQL语句执行对象
    private ResultSet rs = null; // 结果集对象
    private Object[] Param = null; // 给结果集传递参数

    public Object[] getParam () {
        return Param;
    }

    public void setParam (Object[] param) {
        Param = param;
    }

    /*
        方法 获取连接
    */
    public void getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(driver);
        conn = DriverManager.getConnection(URL,user,password);
        System.out.println("数据库连接成功");
    }

    /*
    * 方法 查询全部记录
    * */
    public List<Map<String,Object>> exeQuery(String sql, Object[] Param) throws SQLException, ClassNotFoundException {
        if (conn == null || conn.isClosed()) {
            this.getConnection();
        }

//        sql = "select*from student where name=? or address=?";
//        Pstmt = conn.prepareStatement(sql);
//        Pstmt.setString(1,"1");
//        Pstmt.setString(2,"2");

        Pstmt = conn.prepareStatement(sql);

        // 如果 sql 中含有 ?
        if (Param != null) {
            for (int i = 0;i < Param.length;i++) {
                //如果字段元数据为String型
                if (Param[i].getClass().getTypeName() == "java.lang.String") {
                    Pstmt.setString(i+1,(String)Param[i]);
                    //如果字段元数据为int型
                } else if (Param[i].getClass().getTypeName() == "java.lang.Integer") {
                    Pstmt.setInt(i+1,(int)Param[i]);
                } else if (Param[i].getClass().getTypeName() == "java.lang.Boolean") {
                    Pstmt.setBoolean(i+1,(Boolean) Param[i]);
                }
            }
        }
        rs = Pstmt.executeQuery();
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        while (rs.next()) {
            Map<String,Object> field = new HashMap<>();
            for (int i = 1;i<=rs.getMetaData().getColumnCount();i++) {
                if (rs.getMetaData().getColumnType(i) == Types.VARCHAR) {

                    //           元数据           字段名
                    field.put(rs.getMetaData().getColumnName(i),rs.getString(i));
                } else if (rs.getMetaData().getColumnType(i) == Types.INTEGER) {
                    field.put(rs.getMetaData().getColumnName(i),rs.getInt(i));
                } else if (rs.getMetaData().getColumnType(i) == Types.FLOAT) {
                    field.put(rs.getMetaData().getColumnName(i),rs.getFloat(i));
                };
            }
            list.add(field);
        }
        return list;
    }

    /*
    * 显示list中结果集
    * */
    public void showRs(List<Map<String,Object>> list){
        for (Map map:list) {
            System.out.println(map);
        }
    }
    /*方法 显示表中的记录数*/
    public int countRecord(String sql) throws SQLException, ClassNotFoundException {
        if (conn == null || conn.isClosed()) {
            this.getConnection();
        }
        Pstmt = conn.prepareStatement(sql);

        rs = Pstmt.executeQuery();
        if (rs != null) {
            rs.next();
            return  rs.getInt(1);
        } else {
            return 0;
        }
    }

    /*方法 执行增删改查*/
    public int exeUpdate(String sql,Object[] Param) throws SQLException, ClassNotFoundException {
        if (conn == null || conn.isClosed()) {
            this.getConnection();
        }
        Pstmt = conn.prepareStatement(sql);

        if (Param != null) {
            for (int i = 0;i < Param.length;i++) {
                //如果字段元数据为String型
                if (Param[i].getClass().getTypeName() == "java.lang.String") {
                    Pstmt.setString(i+1,(String)Param[i]);
                    //如果字段元数据为int型
                } else if (Param[i].getClass().getTypeName() == "java.lang.Integer") {
                    Pstmt.setInt(i+1,(int)Param[i]);
                } else if (Param[i].getClass().getTypeName() == "java.lang.Boolean") {
                    Pstmt.setBoolean(i+1,(Boolean) Param[i]);
                }
            }
        }
        int count = Pstmt.executeUpdate();
        return count;
    }


    public void closeAll() throws SQLException {
        if (conn != null) {
            if (! conn.isClosed()) {
                conn.close();
            }
            if (Pstmt != null) {
                Pstmt.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
    }
}
