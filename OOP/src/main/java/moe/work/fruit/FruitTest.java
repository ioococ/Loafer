package moe.work.fruit;

import org.junit.Test;

/**
 * @Author: nekotako
 * @Description: 属性 测试类
 * @Date: 2023/8/30 19:03 星期三
 */

public class FruitTest {
    @Test
    public void test() {
        Apple apple = new Apple();
        Bana2 bana2 = new Bana2();
        apple.setName("苹果");
        bana2.setName("香蕉");
        apple.setColor("红色");
        bana2.setColor("黄色");
        System.out.println(apple.getName());
        System.out.println(bana2.getName());
        System.out.println(apple.getColor());
        System.out.println(bana2.getColor());
        apple.getAdditionProperty(apple.shape, apple.flavor);
        bana2.getAdditionProperty(bana2.shape, bana2.flavor);
    }
}

class Apple extends Fruit {
    String flavor = "苹果味";
    String shape = "圆形";
}

class Bana2 extends Fruit {
    String flavor = "香蕉味";
    String shape = "月牙形";
}