package moe.work;

/**
 * @Author: nekotako
 * @Date: 2023/8/28 19:58
 */
public class Nine {
    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            for (int j = (6 - i); j > 0; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j < i * 2 + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
