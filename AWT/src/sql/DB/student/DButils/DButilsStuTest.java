package sql.DB.student.DButils;

import sql.DB.student.dao.StudentDao;

public class DButilsStuTest {
    public static void main (String[] args) throws Throwable {
        StudentDao dao = new StudentDao();
        dao.getConnection();
        //调用显示方法(1)只返回数据集的第一条记录
        dao.arrayHandler("select*from student",null);
        //调用显示方法(2) 返回list集中的数组
        dao.arrayListHandler("select*from student",null);
        //调用显示方法(3) 返回JavaBean中的保存的记录集中的第一条记录
        dao.beanHandler("select*from student",null);
        //调用显示方法(4) 返回JavaBean中的保存的记录集中的第一条记录
        dao.beanListHandler("select*from student",null);
        //调用显示方法(5) 返回ScalarHandler
        dao.scalarHandler("select avg(math) as 数学平均分 from student where name='马云'",null);
        //调用显示方法(6) 返回ScalarHandler
        dao.columnListHandler("select name as 姓名 from student",null);
        //调用显示方法(7) 存储在map集合中
        dao.mapHandler("select*from student",null);
        //调用显示方法(8) 存储在list<map集合中
        dao.mapListHandler("select*from student",null);
        //调用显示方法(9) 存储在多map集合中
        dao.keyedHandler("select*from student",null);

        dao.closeAll();
    }
}
