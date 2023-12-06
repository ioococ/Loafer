package com.my.person;

import org.junit.Test;
import junit.framework.Assert.*;

public class PersonTest {
    @Test
    public void personSayTest(){
        Person person = new Person();
        System.out.println("在测试类中调用person对象的personSay()方法")
        peq.personSay();
    }
}
