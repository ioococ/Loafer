package sql.daoproject.szkj.daoTestStu;

import sql.daoproject.szkj.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DaoTest {
    public static void main(String[] args) throws SQLException {
       List<Map<String,Object>> list =new ArrayList<Map<String, Object>>();
       Object[] Param=null;
       Dao dao = new Dao();
       dao.getConnection();


       Param=new Object[] {0,"王五"};
       dao.exeUpdate("update student set math=? where name=?",Param);
       Param = new Object[] {"张三",10,"男","上海",0,0};
       dao.exeUpdate("insert into student (name,age,sex,address,math,english) values(?,?,?,?,?,?)",Param);

       Param=new Object[] {"张三"};
       dao.exeUpdate("delete from student  where name=?",Param);

       list=dao.exeQuery("select * from student",null);
       dao.showRs(list);
       System.out.println("表中共有："+dao.countRecord("select count(*) as count from student")+" 条记录");
       dao.closeAll();
    }
}
