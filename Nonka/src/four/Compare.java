package four;

import java.util.Scanner;

public class Compare {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("输入第一个数：");
        double a = input.nextDouble();
        System.out.print("输入第二个数：");
        double b = input.nextDouble();
        System.out.println(compare(a, b));
        input.close();
    }

    static boolean compare(double a, double b) {
        return a == b;
    }
}
