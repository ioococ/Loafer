package sql;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import sql.DB.student.Bean.Student;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

class DBUtils{
    private Connection conn = null;

    public Connection getConn () {
        return conn;
    }

    public void setConn (Connection conn) {
        this.conn = conn;
    }



    public Connection getConnection() throws ClassNotFoundException, SQLException {
        ComboPooledDataSource cpds = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        cpds = new ComboPooledDataSource();
        conn = cpds.getConnection();
        System.out.println("数据库连接创建成功");
        return conn;
    }

    public int insert(String sql,Object[] param) throws SQLException {
        QueryRunner qr = new QueryRunner();
        int rowCount = qr.update(conn,sql,param);
        DbUtils.closeQuietly(conn);
        return rowCount;
    }

    public int update(String sql,Object[] param) throws SQLException {
        QueryRunner qr = new QueryRunner();
        int rowCount = qr.update(conn,sql,param);
        DbUtils.closeQuietly(conn);
        return rowCount;
    }

    public int delete(String sql,Object[] param) throws SQLException {
        QueryRunner qr = new QueryRunner();
        int rowCount = qr.update(conn,sql,param);
        DbUtils.closeQuietly(conn);
        return rowCount;
    }


    public void arrayHandle(String sql,Object[] param) throws SQLException {
        QueryRunner qr = new QueryRunner();
        Object[] objs = qr.query(conn, sql, new ArrayHandler(), param);
        for (Object obj : objs) {
            System.out.print(obj + "\t");
        }
    }

    public void arrayListHandle(String sql,Object[] param) throws SQLException {
        QueryRunner qr = new QueryRunner();
        List<Object[]> lists = qr.query(conn,sql,new ArrayListHandler(),param);
        for (Object[] objs:lists){
            for (Object obj: objs){
                System.out.print(obj+"\t");
            }
            System.out.println();
        }
    }

    public void beanHandle(String sql,Object[] param) throws SQLException {
        QueryRunner qr = new QueryRunner();
        Student stu = qr.query(conn,sql,new BeanHandler<Student>(Student.class),param);
        System.out.print(stu);
    }

    public void beanListHandle(String sql,Object[] param) throws SQLException {
        QueryRunner qr = new QueryRunner();
        List<Student> list = qr.query(conn,sql,new BeanListHandler<>(Student.class),param);
        for (Student stu:list) {
            System.out.println(stu);
        }
    }

    public void  scalarHandler(String sql,Object[] param) throws SQLException {
        QueryRunner qr = new QueryRunner();
        Object obj = qr.query(conn,sql,new ScalarHandler<Object>("数学平均分"),param);
        System.out.println(obj);
    }

    public void columnListHandler(String sql,Object[] param) throws SQLException {
        QueryRunner qr = new QueryRunner();
        List<Object[]> lists = qr.query(conn,sql, new ColumnListHandler<>("姓名"),param);
        for (Object obj:lists) {
            System.out.println(obj);
        }
    }

    public void mapHandler(String sql,Object[] param) throws SQLException {
        QueryRunner qr = new QueryRunner();
        Map<String,Object> map = qr.query(conn,sql,new MapHandler(),param);
        System.out.println(map);
    }

    public void mapListHandler(String sql,Object[] param) throws SQLException {
        QueryRunner qr = new QueryRunner();
        List<Map<String,Object>> lists = qr.query(conn,sql,new MapListHandler(),param);
        for (Map map:lists) {
            System.out.println(map);
        }
    }

    public void keyedHandler(String sql,Object[] params) throws SQLException {
        QueryRunner qr = new QueryRunner();
        Map<Object,Map<String,Object>> map = qr.query(conn,sql,new KeyedHandler<>(),params);
        for(Object obj: map.keySet()){
            for (String key : map.get(obj).keySet()){
                System.out.println(key + "\t" + map.get(obj).get(key) + "\t");
            }
            System.out.println();
        }
    }
    public void closeAll() throws SQLException {
        if (conn != null || ! conn.isClosed()){
            conn.close();
        }
    }
}

public class Dao {
    public static void main(String[] args) throws Throwable {
        DBUtils studentDao = new DBUtils();
        studentDao.getConnection();
        studentDao.arrayHandle("select * from student where math > 90",null);
        System.out.println();
        studentDao.arrayHandle("select * from student where id > 4 ",null);
        System.out.println();
        studentDao.beanHandle("select * from student where name = '德玛西亚'",null);
        System.out.println();
        studentDao.beanListHandle("select * from student where id <> 2",null);
        System.out.println();
        studentDao.scalarHandler("select avg(math) as 数学平均分 from student where name = '刘德华'",null);
        System.out.println();
        studentDao.columnListHandler("select name as 姓名 from student",null);
        System.out.println();
        studentDao.mapHandler("select * from student where address = '南京'",null);
        System.out.println();
        studentDao.mapListHandler("select * from student where id =?",null);
        System.out.println();
        studentDao.keyedHandler("select * from student where id = 2",null);
        studentDao.closeAll();

    }

}
