package moe.nekotako;

import java.util.Scanner;

/**
 * @Author: nekotako
 * @Date: ${DATE} ${TIME}
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = 0;
        for (int i = 1; i < 6; i++) {
            System.out.println("欢迎光临第" + i + "家专卖店");
            while (true) {
                System.out.print("要离开吗(y/n)");
                boolean doing = input.nextLine().equals("y");

                if (doing) {
                    System.out.println("离店结账");
                    break;
                }
                num++;
            }
        }
        System.out.println("总共买了" + num + "件衣服");
    }
}