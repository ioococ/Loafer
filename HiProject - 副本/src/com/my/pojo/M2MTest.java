package com.my.pojo;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.ArrayList;

class HibernateUtils{
    public static ArrayList getSession(){
        //1.加载Hibernate核心配置文件
        Configuration cfg=new Configuration().configure();
        //2.使用sessionFactory
        SessionFactory sessionFactory=cfg.buildSessionFactory();
        Session session=sessionFactory.openSession();
        ArrayList arrayList=new ArrayList();
        arrayList.add(sessionFactory);
        arrayList.add(session);
        return arrayList;
    }
}

public class M2MTest {
    @Test
    public void test(){
            ArrayList arrayList=HibernateUtils.getSession();
            Session session=(Session) arrayList.get(1);
            SessionFactory sessionFactory=(SessionFactory) arrayList.get(0);
        try{
            session.beginTransaction();
            //1.创建两个学生
            Student stu1=new Student();
            Student stu2=new Student();
            stu1.setName("张三");
            stu2.setName("李四");
            //2.创建两个科目
            Course c1 = new Course();
            Course c2 = new Course();
            c1.setCname("Java");
            c2.setCname("PHP");
            //3.建立关联关系
            stu1.getCourses().add(c1);
            stu2.getCourses().add(c1);
            stu1.getCourses().add(c2);
            stu2.getCourses().add(c2);
            //4.存储
            session.save(c1);
            session.save(c2);
            session.save(stu1);
            session.save(stu2);
            session.getTransaction().commit();
        }catch (HibernateException e){
            session.getTransaction().rollback();
        }finally {
            session.close();
            sessionFactory.close();
        }
    }
    @Test
    public void JlSave(){
        ArrayList arrayList=HibernateUtils.getSession();
        Session session=(Session)arrayList.get(1);
        SessionFactory sessionFactory=(SessionFactory)arrayList.get(0);
        session.beginTransaction();
        try {
            session.beginTransaction();
            Course course = new Course();
            course.setCname("");
            Student student = new Student();
            student.getCourses().add(course);
            session.save(student);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
    @Test
    public void JlDelete(){
        ArrayList arrayList=HibernateUtils.getSession();
        Session session=(Session)arrayList.get(1);
        SessionFactory sessionFactory=(SessionFactory)arrayList.get(0);
        session.beginTransaction();

    }
}
