package com.my.pojo;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;

public class Test {
    @org.junit.Test
    public void Testv(){
        ArrayList arrayList = HibernateUtils.getSession();
        SessionFactory sF = (SessionFactory) arrayList.get(0);
        Session s = (Session) arrayList.get(1);
        try {
            s.beginTransaction();
            UsertableEntity usertableEntity = s.get(UsertableEntity.class,32);
            System.out.println(usertableEntity.getId());
            System.out.println(usertableEntity.getUsername());
//            s.beginTransaction().commit();
        } catch (HibernateException e) {
            s.beginTransaction().rollback();
        } finally {
            s.close();
            sF.close();
        }
    }

    @org.junit.Test
    public void Testw(){
        ArrayList arrayList = HibernateUtils.getSession();
        SessionFactory sF = (SessionFactory) arrayList.get(0);
        Session s = (Session) arrayList.get(1);
        try {
            s.beginTransaction();
            UsertableEntity usertableEntity = s.get(UsertableEntity.class,32);
           usertableEntity.setPassword("1234");
            System.out.println(usertableEntity.getUsername());
        } catch (HibernateException e) {
            s.beginTransaction().rollback();
        } finally {
            s.close();
            sF.close();
        }
    }
}
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