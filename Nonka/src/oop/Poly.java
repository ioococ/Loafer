package oop;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 2023/10/9 20:16 星期一
 */

public class Poly {
    public static void main(String[] args) {
        Sup sub = new Sub();
        System.out.println(sub.age);
        sub.m1();
        sub.m2();
//        sub.m3();
    }
}
class Sup{
    int age = 2;
    public void m1(){
        System.out.println("Father m1");
    }
    public void m2(){
        System.out.println("Father m2");
    }
}
class Sub extends Sup{
    int age = 1;
    public void m2(){
        System.out.println("Son m2");
    }
    public void m3(){
        System.out.println("Son m3");
    }
}
