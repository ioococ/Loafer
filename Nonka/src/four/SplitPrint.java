package four;

import java.util.Scanner;

public class SplitPrint {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入: ");
        int num = input.nextInt();
        splitPrint(num);
        input.close();

    }

    static void splitPrint(int a) {
        if (a <= 9) {
            System.out.println(a);
            return;
        }
        int m = a % 10;
        int x = a / 10;
        splitPrint(x);
        System.out.println(m);
    }
}
