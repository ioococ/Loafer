package com.my.pojo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class M2OTest {
    @Test
    public void addData() {
        Configuration cfg = new Configuration().configure();
        SessionFactory sF = cfg.buildSessionFactory();
        Session session = sF.openSession();
        Transaction t = session.beginTransaction();
        Customer customer = new Customer();
        customer.setName("ZhangSan");
        customer.setAddress("ShiJiaZhang");
        Orders rice = new Orders();
        Orders cola = new Orders();
        rice.setSpname("盖饭");
        cola.setSpname("可乐");
        rice.setCustomer(customer);
        rice.setCustomer(customer);
        session.save(customer);
        session.save(rice);
        session.save(cola);
        t.commit();
        session.close();
        sF.close();
    }
}
