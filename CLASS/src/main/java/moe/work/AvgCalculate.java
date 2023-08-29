package moe.work;

import java.util.Scanner;

/**
 * @Author: nekotako
 * @Description: 计算平均分和总成绩
 * @Date: 2023/8/29 18:59 星期二
 */

public class AvgCalculate {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Calculate calc = new Calculate();
        float kfc = 0.0F, fkxqs = 0.0F, vme50 = 0.0F;
        System.out.print("请输入Java成绩：");
        kfc = input.nextInt();
        System.out.print("请输入C#成绩：");
        fkxqs = input.nextInt();
        System.out.print("请输入DB成绩：");
        vme50 = input.nextInt();
        float sum = calc.xc(kfc, fkxqs, vme50);
        System.out.println("总成绩是：" + (int) sum);
        System.out.println("平均成绩是：" + sum / 4);
    }
}

class Calculate {
    float xc(float javaScore, float csharpScore, float dbScore) {
        float yxqc = (javaScore + csharpScore + dbScore);
        return yxqc;
    }
}
