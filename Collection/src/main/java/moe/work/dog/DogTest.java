package moe.work.dog;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 2023/8/31 19:47 星期四
 */

public class DogTest {
    @Test
    public void main(){
        ArrayList<Dog> list = new ArrayList<>();
        Dog ou = new Dog("欧欧","雪娜瑞");
        Dog ya = new Dog("亚亚","拉布拉多");
        Dog fei = new Dog("菲菲","拉布拉多");
        Dog mei = new Dog("美美","雪娜瑞");

        list.add(ou);
        list.add(ya);
        list.add(fei);
        list.add(mei);
        System.out.println("共计有"+list.size()+"条狗狗");
        System.out.println("分别是");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName()+"\t"+list.get(i).getBreed());
        }
    }
}
