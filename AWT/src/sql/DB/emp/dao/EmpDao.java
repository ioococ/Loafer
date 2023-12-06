package sql.DB.emp.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import sql.DB.emp.Bean.Emp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class EmpDao {
    private Connection conn = null;

    public Connection getConn () {
        return conn;
    }

    public void setConn (Connection conn) {
        this.conn = conn;
    }

    public Connection getConnection () throws ClassNotFoundException, SQLException {
        ComboPooledDataSource cpds = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        cpds = new ComboPooledDataSource();
        conn = cpds.getConnection();
        System.out.println("");
        return null;
    }

    public int insert (String sql, Object[] param) throws SQLException {
        QueryRunner qr = new QueryRunner();
        int rowCount = qr.update(conn, sql, param);
        DbUtils.closeQuietly(conn);
        return rowCount;
    }

    public void delete (String sql, Object[] param) throws SQLException {
        QueryRunner qr = new QueryRunner();
        Object objs = qr.update(conn, sql, param);
    }

    public void arrayHandler (String sql, Object[] param) throws SQLException {
        QueryRunner qr = new QueryRunner();
        Object[] objs = qr.query(conn, sql, new ArrayHandler(), param);
        for (Object obj : objs) {
            System.out.print(obj);
        }
    }

    public void arrayListHandler (String sql, Object[] param) throws SQLException {
        QueryRunner qr = new QueryRunner();
        List<Object[]> lists = qr.query(conn, sql, new ArrayListHandler(), param);
        for (Object[] objs : lists) {
            for (Object obj : objs) {
                System.out.print(obj);
            }
            System.out.println();
        }
    }

    public void beanHandler (String sql, Object[] param) throws SQLException {
        QueryRunner qr = new QueryRunner();
        Emp emp = qr.query(conn, sql, new BeanHandler<Emp>(Emp.class), param);
        System.out.println(emp);
    }

    public void beanListHandler (String sql, Object[] param) throws SQLException {
        QueryRunner qr = new QueryRunner();
        List<Emp> lists = qr.query(conn, sql, new BeanListHandler<>(Emp.class), param);
        for (Emp emp : lists) {
            System.out.println(emp);
        }
    }

    public void scalarhandler (String sql, Object[] param) throws SQLException {
        QueryRunner qr = new QueryRunner();
        Object obj = qr.query(conn, sql, new ScalarHandler<Object>("数学平均分"), param);
        System.out.println(obj);
    }

    public void columnHandle (String sql, Object[] param) throws SQLException {
        QueryRunner qr = new QueryRunner();
        List<Object> lists = qr.query(conn, sql, new ColumnListHandler<Object>("姓名"), param);
        for (Object obj : lists) {
            System.out.println(obj);
        }
    }

    public void mapHandler (String sql, Object[] param) throws SQLException {
        QueryRunner qr = new QueryRunner();
        Map<String, Object> map = qr.query(conn, sql, new MapHandler(), param);
        System.out.println(map);
    }

    public void mapListHandler (String sql, Object[] param) throws SQLException {
        QueryRunner qr = new QueryRunner();
        List<Map<String, Object>> lists = qr.query(conn, sql, new MapListHandler(), param);
        for (Map map : lists) {
            System.out.println(map);
        }
    }

    public void keyHandler (String sql, Object[] param) throws SQLException {
        QueryRunner qr = new QueryRunner();
        Map<Object, Map<String, Object>> maps = qr.query(conn, sql, new KeyedHandler<>(), param);
        for (Object obj : maps.keySet()) {
            for (String key : maps.get(obj).keySet()) {
                System.out.println(key + "\t" + maps.get(obj).get(key) + "\t");
            }
        }
    }
}














