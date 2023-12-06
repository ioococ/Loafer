package com.my.person;

import org.junit.Test;
import static junit.framework.Assert.*;
public class PersonTest{
    @Test
    public void PersonClassTest(){
        Person person = new Person();
        person.personSay();
    }
}
