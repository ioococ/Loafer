package sql.daoproject.szkj.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dao {
    //连接数据库的四要点
    private String driver = "com.mysql.jdbc.Driver";
    private String URL = "jdbc:mysql://localhost:3306/test?characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";
    private String user = "root";
    private String password = "123456";

    private String sql = null; //sql字串
    private Connection conn = null; //连接对象
    private PreparedStatement Pstmt = null; //SQL语句执行对象
    private ResultSet rs = null; //结果集对象
    private Object[] Param = null; //给sql语句传参数用

    public Object[] getParam() {
        return Param;
    }

    public void setParam(Object[] param) {
        Param = param;
    }

    //1.获取连接的方法
    public void getConnection() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(URL, user, password);
            System.out.println("数据库连接成功！");
        } catch (Exception e) {
            System.out.println("数据库连接失败！");
            e.printStackTrace();
            System.exit(0);
        }
    }
    //2.查询全部记录
    //sql="select * from student where name=? or address=？";
    //Param={"马云",  "上海"  };
    public List<Map<String,Object>> exeQuery(String sql, Object[] Param) throws SQLException {
         if (conn==null || conn.isClosed()){
             this.getConnection();
         }

         Pstmt =conn.prepareStatement(sql);
         if (Param!=null){
             for (int i=0;i<Param.length;i++){
                 if(Param[i].getClass().getTypeName()=="java.lang.String"){
                     Pstmt.setString(i+1,(String)Param[i]);
                 }else if(Param[i].getClass().getTypeName()=="java.lang.Integer"){
                     Pstmt.setInt(i+1,(int)Param[i]);
                 }else if (Param[i].getClass().getTypeName()=="java.lang.Boolean"){
                     Pstmt.setBoolean(i+1,(Boolean) Param[i]);
                 }
             }
         }
         rs=Pstmt.executeQuery();

         List<Map<String,Object>> list =new ArrayList<Map<String, Object>>();
         while (rs.next()){
             Map<String,Object> field =new HashMap<String,Object>();
             for (int i=1;i<=rs.getMetaData().getColumnCount();i++){
                if(rs.getMetaData().getColumnType(i)== Types.VARCHAR){
                    field.put(rs.getMetaData().getColumnName(i),rs.getString(i));
                }else if (rs.getMetaData().getColumnType(i)== Types.INTEGER){
                    field.put(rs.getMetaData().getColumnName(i),rs.getInt(i));
                }else if (rs.getMetaData().getColumnType(i)== Types.FLOAT) {
                    field.put(rs.getMetaData().getColumnName(i),rs.getFloat(i));
                };
             }
             list.add(field);
         }
         return list;
    }
    //3.显示list中的结果集
    public void  showRs(List<Map<String,Object>> list){
        for (Map map:list) {
            System.out.println(map);
        }
    }
    //4.显示表中的记录数
    //////sql="select count(*) as count from student";
    public int countRecord(String sql) throws SQLException {
        if (conn==null || conn.isClosed()){
            this.getConnection();
        }
        Pstmt=conn.prepareStatement(sql);
        rs=Pstmt.executeQuery();
        if (rs!=null){
            rs.next();
            return  rs.getInt(1);
        }else{
            return 0;
        }
    }
    //5.执行增，删，改的方法
    public  int exeUpdate(String sql,Object [] Param) throws SQLException {
        if (conn==null || conn.isClosed()){
            this.getConnection();
        }
        Pstmt =conn.prepareStatement(sql);
        if (Param!=null){
            for (int i=0;i<Param.length;i++){
                if(Param[i].getClass().getTypeName()=="java.lang.String"){
                    Pstmt.setString(i+1,(String)Param[i]);
                }else if(Param[i].getClass().getTypeName()=="java.lang.Integer"){
                    Pstmt.setInt(i+1,(int)Param[i]);
                }else if (Param[i].getClass().getTypeName()=="java.lang.Boolean"){
                    Pstmt.setBoolean(i+1,(Boolean) Param[i]);
                }
            }
        }
        int count=Pstmt.executeUpdate();
        return count;
    }

    //释放资源
    public void closeAll() throws SQLException {
        if (conn!=null){
            if (!conn.isClosed()) {
                conn.close();
            }
        }
        if (Pstmt!=null){
            Pstmt.close();
        }
        if (rs!=null){
            rs.close();
        }
    }


}
