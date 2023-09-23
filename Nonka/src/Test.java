import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        int a = 1;
        long b = 2;
        // b = (byte) (a + b);
        a += b;
        // a = a + b;
        Scanner input = new Scanner(System.in);
        System.out.print("请输入年龄");
        int i = input.nextInt();
        if (i <= 15)
            System.out.println();
        else if (i <= 25 && i > 15) {

        } else if (i <= 45 && i > 25) {

        } else {

        }
    }
}