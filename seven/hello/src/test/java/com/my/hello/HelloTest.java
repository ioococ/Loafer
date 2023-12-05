package com.my.hello;

import junit.framework.Assert.*;
import org.junit.Test;

public class HelloTest{
    @Test
    public void HelloClassTest(){
        Hello hello = new Hello();
        String res = hello.sayHello("Gu Ailing Eileen");
        System.out.println(res);
    }
}
