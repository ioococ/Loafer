package four;

import java.util.Scanner;

public class InputSum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("输入: ");
        int num = input.nextInt();
        System.out.println(inputSum(num));
        input.close();
    }

    static int inputSum(int num) {
        if (num == 1) {
            return 1;
        }
        System.out.println(num);
        return num + inputSum(num - 1);
    }
}
