package four;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        System.out.print("输入数字：");
        Scanner input = new Scanner(System.in);
        System.out.println(judge(input.nextInt()));
        input.close();
    }

    static boolean judge(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
