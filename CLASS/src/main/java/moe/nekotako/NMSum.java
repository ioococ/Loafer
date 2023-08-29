package moe.nekotako;

import java.util.Scanner;

/**
 * @Author: nekotako
 * @Date: 2023/8/29 15:21
 */
public class NMSum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        NMSum sum = new NMSum();
        System.out.print("最小值：");
        int n = input.nextInt();
        System.out.print("最大值：");
        int m = input.nextInt();
        System.out.println(sum.oi(n, m));

    }

    public int oi(int n, int m) {
        int total = 0;
        for (; n <= m; n++) {
            total += n;
        }
        return total;
    }
}
