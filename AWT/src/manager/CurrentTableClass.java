package manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CurrentTableClass {
    //1.全部数据
    public Object[][] currentNumRows(Connection conn) throws SQLException {
        PreparedStatement Pstmt=null;
        String sql="select bh,name,num from CurrentTable";
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
    //2.表格列头
    public String[] currentNumColumn(Connection conn) throws SQLException {
        PreparedStatement Pstmt=null;
        String sql="select bh as 编号,name as 名称,num as 数量  from CurrentTable where id=-1";
        Pstmt= conn.prepareStatement(sql);
        ResultSet rs=Pstmt.executeQuery(); //返回的结果集

        String[] ColumnNames =new String[rs.getMetaData().getColumnCount()];
        for (int i=1;i<=rs.getMetaData().getColumnCount();i++) {
            ColumnNames[i-1]=rs.getMetaData().getColumnLabel(i);
        }
        return ColumnNames;//返回列头
    }
}
