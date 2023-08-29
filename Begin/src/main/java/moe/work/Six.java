package moe.work;

import java.util.Scanner;

/**
 * @Author: nekotako
 * @Date: 2023/8/28 20:12
 */
public class Six {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int things = 0;
        int price = 0;
        int num = 0;
        System.out.println("*******************");
        System.out.println("请选择购买的商品编号:");
        System.out.println("1.T 恤      2.网球鞋      3.网球拍");
        System.out.println("*******************");
        System.out.println();

        while (true) {
            Scanner flag = new Scanner(System.in);
            String str = "";
            System.out.println("要离开吗(y/n)：");
            str = flag.nextLine();

            if (str.equals("y")) {
                System.out.println();
                System.out.println("离店结账");
                System.out.println();
                break;
            } else {
                System.out.print("请输入商品编号：");
                things = input.nextInt();
                System.out.print("请输入购买数量：");
                num = input.nextInt();
                switch (things) {
                    case 1 -> price = 100 * num + price;
                    case 2 -> price = 200 * num + price;
                    case 3 -> price = 300 * num + price;
                    default -> System.exit(0);
                }
            }
        }

        System.out.println("折扣: 8.8");
        System.out.println("应付金额：" + price);
        System.out.println("实付金额：" + (price - 8.8));
    }
}
