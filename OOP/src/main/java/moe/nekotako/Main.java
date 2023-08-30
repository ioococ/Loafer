package moe.nekotako;

import org.junit.Test;

/**
 * @Author: nekotako
 * @Description: OOP
 * @Date: ${DATE} ${TIME} ${DAY_NAME_FULL}
 */

public class Main {
    private int num;

    @Test
    public void main() {

        Animals dog = new Dog();

        Dog huahua = (Dog) dog;
        huahua.setColor("white");
        System.out.println(huahua.getColor());
    }
}