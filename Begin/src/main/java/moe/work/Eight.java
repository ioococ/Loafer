package moe.work;

import java.util.Scanner;

/**
 * @Author: nekotako
 * @Date: 2023/8/28 20:05
 */
public class Eight {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        for (int i = 1; i < 4; i++) {
            float num = 0F;
            System.out.println("请输入第" + i + "班的成绩");
            for (int j = 1; j < 5; j++) {
                System.out.print("第" + j + "学员的成绩：");
                num += input.nextInt();
            }
            System.out.println("第" + i + "个班级参赛学员的平均分是：" + num / 4);
            System.out.println();
        }
    }
}
