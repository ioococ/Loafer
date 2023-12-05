package cn.my.jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Template {
    public void create(String Tablename) {
        String XmlFile = "beans.xml";
        ApplicationContext aC = new ClassPathXmlApplicationContext(XmlFile);
        JdbcTemplate t = aC.getBean("template", JdbcTemplate.class);
        t.execute("create table if not exists " + Tablename + "(userId int primary key auto_increment, username varchar(10), password varchar(10))");
    }

    public void drop(String Tablename) {
        String XmlFile = "beans.xml";
        ApplicationContext aC = new ClassPathXmlApplicationContext(XmlFile);
        JdbcTemplate t = aC.getBean("template", JdbcTemplate.class);
        t.execute("drop table " + Tablename);
    }
    @Test
    public void test(){
        create("Spring");
//        drop("Spring");
    }
}
