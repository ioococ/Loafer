package moe.work;

import java.util.Scanner;

/**
 * @Author: nekotako
 * @Description: 一个景区根据游人的年龄收取不同价格的门票
 * @Date: 2023/8/29 16:47 星期二
 */

public class TicketsSort {
    public static void main(String[] args) {
        Person brysj = new Person();
        while (true) {
            Scanner hhyhl = new Scanner(System.in);
            System.out.print("请输入姓名：");
            String flzxsqc = hhyhl.nextLine();
            if (flzxsqc.equals("n")) {
                break;
            }
            System.out.print("请输入年龄：");
            int ysyhljt = hhyhl.nextInt();
            brysj.ageDecide(flzxsqc, ysyhljt);
        }
    }
}

class Person {
    void ageDecide(String name, int age) {
        if (age > 10) {
            adultFee(name, age);
        } else {
            childFee(name, age);
        }
    }

    void adultFee(String name, int age) {
        System.out.println(name + "的年龄为" + age + "，门票价格为：20元");
    }

    void childFee(String name, int age) {
        System.out.println(name + "的年龄为" + age + "，门票免费");
    }
}
