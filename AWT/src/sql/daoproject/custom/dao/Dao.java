package sql.daoproject.custom.dao;

import java.sql.*;
import java.util.*;

public class Dao {

    private Connection conn = null;
    private PreparedStatement Pstmt = null;
    private ResultSet rs = null;
    private  Object[] Param = null;

    public Object[] getParam () {
        return Param;
    }

    public void setParam (Object[] param) {
        Param = param;
    }
    public void getConnection() throws ClassNotFoundException, SQLException {
        String driver = "com.mysql.cj.jdbc.Driver";
        Class.forName(driver);
        String URL = "jdbc:mysql://localhost:3306/test?characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";
        String password = "123456";
        String user = "root";
        conn = DriverManager.getConnection(URL, user, password);
        System.out.println("数据库连接成功");
    }
    public List<Map<String,Object>> exeQuery(String sql,Object[] Param) throws SQLException, ClassNotFoundException {
        if (conn == null || conn.isClosed()){
            this.getConnection();
        }
        Pstmt = conn.prepareStatement(sql);
        if (Param != null){
            for (int i = 0;i < Param.length;i++){
                if (Param.getClass().getTypeName() == "java.lang.String"){
                    Pstmt.setString(i+1, (String) Param[i]);
                } else if (Param.getClass().getTypeName() == "java.lang.Integer"){
                    Pstmt.setInt(i+1, (int) Param[i]);
                } else if (Param.getClass().getTypeName() == "java.lang.Boolean"){
                    Pstmt.setBoolean(i+1, (Boolean) Param[i]);
                }
            }
        }
        rs = Pstmt.executeQuery();
        List<Map<String,Object>> list = new ArrayList<>();
        while (rs.next()) {
            Map<String,Object> field = new HashMap<>();
            for (int i = 1;i <= rs.getMetaData().getColumnCount();i++){
                if (rs.getMetaData().getColumnType(i) == Types.VARCHAR){
                    field.put(rs.getMetaData().getColumnName(i),rs.getString(i));
                } else if (rs.getMetaData().getColumnType(i) == Types.INTEGER){
                    field.put(rs.getMetaData().getColumnName(i),rs.getInt(i));
                } else if (rs.getMetaData().getColumnType(i) == Types.FLOAT){
                    field.put(rs.getMetaData().getColumnName(i),rs.getFloat(i));
                };
            }
            list.add(field);
        }
        return list;
    }
    public void showRs(List<Map<String,Object>> list){
        for (Map map:list) {
            System.out.println(map);
        }
    }
    public int countRecord(String sql) throws SQLException, ClassNotFoundException {
        if (conn == null || conn.isClosed()){
            this.getConnection();
        }
        Pstmt = conn.prepareStatement(sql);
        rs = Pstmt.executeQuery();
        if (rs != null){
            rs.next();
            return rs.getInt(1);
        } else {
            return  0;
        }
    }
    public int exeUpdate(String sql,Object[] Param) throws SQLException, ClassNotFoundException {
        if (conn == null) {
            Objects.requireNonNull(conn).isClosed();
        }
        this.getConnection();
        Pstmt = conn.prepareStatement(sql);

        if (Param != null) {
            for (int i = 0; i < Param.length; i++) {
                //如果字段元数据为String型
                if (Param[i].getClass().getTypeName() == "java.lang.String") {
                    Pstmt.setString(i + 1, (String) Param[i]);
                    //如果字段元数据为int型
                } else if (Param[i].getClass().getTypeName() == "java.lang.Integer") {
                    Pstmt.setInt(i + 1, (int) Param[i]);
                } else if (Param[i].getClass().getTypeName() == "java.lang.Boolean") {
                    Pstmt.setBoolean(i + 1, (Boolean) Param[i]);
                }
            }
        }
        return Pstmt.executeUpdate();
    }
    public void cloesAll() throws SQLException {
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
