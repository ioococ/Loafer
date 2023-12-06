package manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class UserTableClass {
    public boolean existsUser(Connection conn, String username) throws SQLException {
        PreparedStatement Pstmt = null;
        String sql = "select id from userTable where name=?";
        try {
            Pstmt = conn.prepareStatement(sql);
            Pstmt.setString(1, username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet rs = Pstmt.executeQuery();
        if (rs.next()) {
            return true;
        } else {
            return false;
        }
    }

    //增加
    public boolean addUser(Connection conn, String userName, String password) throws SQLException {
        java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
        PreparedStatement Pstmt = null;
        String sql = "insert into userTable(username,password,createuser,createdate) values(?,?,?,?)";
        Pstmt = conn.prepareStatement(sql);
        Pstmt.setString(1, userName);
        Pstmt.setString(2, password);
        Pstmt.setString(3, null);
        Pstmt.setDate(4, currentDate);
        Boolean b = Pstmt.execute();
        return b;
    }

    //删除
    public boolean deleteUser(Connection conn, String userName) throws SQLException {
        PreparedStatement Pstmt = null;
        String sql = "delete from userTable where username=?";
        Pstmt = conn.prepareStatement(sql);
        Pstmt.setString(1, userName);
        Boolean b = Pstmt.execute();
        return b;
    }

    //登录
    public boolean validationUser(Connection conn, String user, String password) throws SQLException {
        PreparedStatement Pstmt = null;
        String sql = "select id from userTable where username=? and password=?";
        Pstmt = conn.prepareStatement(sql);
        Pstmt.setString(1, user);
        Pstmt.setString(2, password);
        ResultSet rs = Pstmt.executeQuery();
        if (rs.next()) {
            return true;
        } else {
            return false;
        }
    }

    //全部用户数据
    public Object[][] userRows(Connection conn) throws SQLException {
        PreparedStatement Pstmt=null;
        String sql="select id,username,createuser,createdate from userTable";
        Pstmt= conn.prepareStatement(sql);
        ResultSet rs=Pstmt.executeQuery(); //返回的结果集

        ArrayList <ArrayList<Object>> RowsList =new ArrayList<ArrayList<Object>>();
        rs.beforeFirst();
        while (rs.next()) {
            ArrayList <Object> Row =new ArrayList<Object>();
            for (int i=1;i<=rs.getMetaData().getColumnCount();i++) {
                Row.add(rs.getObject(i));
            }
            RowsList.add(Row);
        }
        int m=RowsList.size();
        int n=rs.getMetaData().getColumnCount();
        Object[][] Rows =new Object[m][n];
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                Rows[i][j]=RowsList.get(i).get(j);
            }
        }
        return Rows;//返回所有行
    }
    //表格列头
    public String[] userColumn(Connection conn) throws SQLException {
        PreparedStatement Pstmt=null;
        String sql="select id as id,username as 用户名,createuser as 创建人,createdate as 创建日期 from userTable where id=-1";
        Pstmt= conn.prepareStatement(sql);
        ResultSet rs=Pstmt.executeQuery(); //返回的结果集

        String[] ColumnNames =new String[rs.getMetaData().getColumnCount()];
        for (int i=1;i<=rs.getMetaData().getColumnCount();i++) {
            ColumnNames[i-1]=rs.getMetaData().getColumnLabel(i);
        }
        return ColumnNames;//返回列头
    }

    public int  Modifypwd(Connection conn,String userName,String PassWord) throws SQLException {
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
        //System.out.println("当前时间为: " + ft.format(dNow));
        String SDate= ft.format(dNow);

        PreparedStatement Pstmt=null;
        String sql="update userTable set password=? where username=?";
        Pstmt= conn.prepareStatement(sql);
        Pstmt.setString(1,PassWord); //第一个参数赋值
        Pstmt.setString(2,userName); //第二个参数赋值
        int num=Pstmt.executeUpdate(); //返回的结果集
        return num;
    }

    public boolean DlYz(Connection conn,String userName,String PassWord) throws SQLException {
        PreparedStatement Pstmt=null;
        String sql="select id  from  userTable where  username=? and password=?";
        Pstmt= conn.prepareStatement(sql);
        Pstmt.setString(1,userName); //第一个参数赋值
        Pstmt.setString(2,PassWord); //第二个参数赋值
        ResultSet rs=Pstmt.executeQuery(); //返回的结果集
        if (rs.next()) {
            return true; //说明找到了此条记录，输入的用户名和密码是对应的
        }else {
            return false;//说明输入用户名和密码不一致
        }
    }
}
