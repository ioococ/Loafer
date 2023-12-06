package sql.DB.student.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import sql.DB.student.Bean.Student;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class StudentDao {
    /*
    c3p0通过Xml文件匹配连接池
        配置c3p0—config.xml文件
        定义ComboPooledDataSource连接池变量
        定义Connection连接变量
        定义数据库驱动程序
        创建数据库连接池对象给ComboPooledDataSource变量
        创建Connection对象
    * */

    //创建一个全局变量
    private Connection conn = null;

    public Connection getConn () {
        return conn;
    }

    public void setConn (Connection conn) {
        this.conn = conn;
    }


//    public StudentDao () throws ClassNotFoundException, SQLException {
//        ComboPooledDataSource cpds = null;
////        Connection conn = null;
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        //通过连接池获取数据库连接
//        cpds = new ComboPooledDataSource();
//        conn = cpds.getConnection();
//        System.out.println("数据库连接创建成功");
//        return conn;
//    }

    //定义连接方法
    public Connection getConnection () throws ClassNotFoundException, SQLException {
        ComboPooledDataSource cpds = null;
//        Connection conn = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        //通过连接池获取数据库连接
        cpds = new ComboPooledDataSource();
        conn = cpds.getConnection();
        System.out.println("数据库连接创建成功");
        return conn;
    }

    //定义增加记录方法
    public int insert (String sql, Object[] param) throws SQLException {
//    Object[] params = {"李四",33,"男","河北",100,60};
//    String sql = "insert into student(name,age,sex,address,math,english) values(?,?,?,?,?,?)";
        QueryRunner qr = new QueryRunner();
        //调用QueryRunner的update方法执行sql语句
        int rowCount = qr.update(conn, sql, param);
        //将连接返还连接池
        DbUtils.closeQuietly(conn);
        return rowCount;
    }

    //定义修改记录方法
    public int update (String sql, Object[] param) throws SQLException {
//    Object[] params = {34,"李四"};
//    String sql = "update student set age=? where name=?";
        QueryRunner qr = new QueryRunner();
        //调用QueryRunner的update方法执行sql语句
        int rowCount = qr.update(conn, sql, param);
        //将连接返还连接池
        DbUtils.closeQuietly(conn);
        return rowCount;
    }

    //定义删除记录方法
    public int delete (String sql, Object[] param) throws SQLException {
//    Object[] params = {"李四"};
//    String sql = "delete from student where name=?";
        QueryRunner qr = new QueryRunner();
        //调用QueryRunner的update方法执行sql语句
        int rowCount = qr.update(conn, sql, param);
        //将连接返还连接池
        DbUtils.closeQuietly(conn);
        return rowCount;
    }

    //定义查询记录方法
    // 1

    //字段对应的是name , age，sex, address math, english
    //Object[] params = {"李四"};这里需注意参数位置要正确，如果没有参数，传参时写成null
    //String sqL = "seLect * from student";
    //不同的ResultSetHandLer实现类，来处理结果集
    //结果集的第一种实现类 ArrayHandle,返回结果集中的一行数据

    public void arrayHandler (String sql, Object[] param) throws SQLException {
        //创建一个QueryRunner对象
        QueryRunner qr = new QueryRunner();
        //调用QueryRunner方法并执行SQL,创建一个Array数组,用来存放返回值
        Object[] objs = qr.query(conn, sql, new ArrayHandler(), param);
        //打印输出
        for (Object obj : objs) {
            System.out.print(obj + "\t");
        }
    }

    // 2
    public void arrayListHandler (String sql, Object[] param) throws SQLException {
//        //创建一个QueryRunner对象
        QueryRunner qr = new QueryRunner();
        //调用QueryRunner的query方法并执行SQL,创建一个List数组,用来存放返回值
        List<Object[]> lists = qr.query(conn, sql, new ArrayListHandler(), param);
        //打印输出
        for (Object[] objs : lists) {
            for (Object obj : objs) {
                System.out.print(obj + "\t");
            }
            System.out.println();
        }
    }

    //3 BeanHandler 将结果集的第一行存储到JavaBean中
    public void beanHandler (String sql, Object[] param) throws SQLException {
        //创建一个QueryRunner对象
        QueryRunner qr = new QueryRunner();
        //调用QueryRunner的query方法并执行SQL,创建JavaBean对象存放结果集
        Student stu = qr.query(conn, sql, new BeanHandler<Student>(Student.class), param);
        //打印输出
        System.out.print(stu);
    }

    //4 BeanListHandler将结果集的存储到JavaBean中
    public void beanListHandler (String sql, Object[] param) throws SQLException {
        //创建一个QueryRunner对象
        QueryRunner qr = new QueryRunner();
        //调用QueryRunner的query方法并执行SQL,创建List集合,创建JavaBean对象存放结果集
        List<Student> list = qr.query(conn, sql, new BeanListHandler<>(Student.class), param);
        //打印输出
        for (Student stu : list) {
            System.out.println(stu);
        }
    }

    //5 ScalarHandler 适合单个查询, select结果集只有一个值
    public void scalarHandler (String sql, Object[] param) throws SQLException {
        QueryRunner qr = new QueryRunner();
        //传入的sql只能有一个值
        Object obj = qr.query(conn, sql, new ScalarHandler<Object>("数学平均分"), param);
        System.out.println(obj);
    }

    //6 ColumnListHandler 存储一个列到集合 中
    public void columnListHandler (String sql, Object[] param) throws SQLException {
        QueryRunner qr = new QueryRunner();
        //调用query方法执行sql,将一列数据放入集合中
        List<Object[]> lists = qr.query(conn, sql, new ColumnListHandler<>("姓名"), param);
        for (Object obj : lists) {
            System.out.println(obj);
        }
    }

    //7 MapHandler 将结果集中的第一行存储在Map集合中 k为列名 v为列中的值
    public void mapHandler (String sql, Object[] param) throws SQLException {
        QueryRunner qr = new QueryRunner();
        //执行sql,把返回的结果集第一行装入map集合中
        Map<String, Object> map = qr.query(conn, sql, new MapHandler(), param);
        System.out.println(map);
    }

    //8 MapListHandler 将结果集中的第一行存储在Map集合中 k为列名 v为列中的值
    public void mapListHandler (String sql, Object[] param) throws SQLException {
        QueryRunner qr = new QueryRunner();
        //执行sql,把返回的结果集第一行装入map集合中
        List<Map<String, Object>> lists = qr.query(conn, sql, new MapListHandler(), param);
        for (Map map : lists) {
            System.out.println(map);
        }
    }

    //9 keyedHander 结果集的每一行都存储在map集合中,将多个map集合在存储在map中
    public void keyedHandler (String sql, Object[] params) throws SQLException {
        QueryRunner qr = new QueryRunner();
        //执行sql,把返回的结果集第一行装入多map集合中
        Map<Object, Map<String, Object>> map = qr.query(conn, sql, new KeyedHandler<>(), params);
        for (Object obj : map.keySet()) {
            for (String key : map.get(obj).keySet()) {
                System.out.println(key + "\t" + map.get(obj).get(key) + "\t");
            }
            System.out.println();
        }
    }


    //定义释放资源方法
    public void closeAll () throws SQLException {
        if (conn != null || ! conn.isClosed()) {
            conn.close();
        }
    }
}
