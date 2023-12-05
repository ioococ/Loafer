package sql.daoproject.daoTestStu;

import sql.daoproject.dao.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DaoTest {
    public static void main(String[] args) throws Throwable{
        List list = new ArrayList<Map<String,Object>>();
        Dao dao = new Dao();
        Object[] Param = null;
        dao.getConnection();

        Param = new Object[] {100,"王五"};
        dao.exeUpdate("update student set math=? where name=?",Param);

        Param = new Object[] {"张三",10,"男","上海",0,0};
        dao.exeUpdate("insert into student(name,age,sex,address,math,english) values(?,?,?,?,?,?)",Param);

        Param = new Object[] {"张三"};
        dao.exeUpdate("delete from student  where name=?",Param);

        list = dao.exeQuery("select*from student",null);
        dao.showRs(list);
        System.out.println("当前表中共有"+dao.countRecord("select count(*) from student")+"条记录");
    }
}
