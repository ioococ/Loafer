import java.util.Scanner;

public class Coding {
    public static void main(String[] args) {
       Coding c = new Coding();
       c.cycling();
    }

    public void judge() {
        Scanner input = new Scanner(System.in);
        System.out.print("输入成绩");
        double score = input.nextDouble();
        int i = (int) (score / 10);
        Math.round(i);
        switch (i) {
            case 10:
                System.out.println(10);
                break;
            case 9:
                System.out.println(9);
                break;
            case 8:
                System.out.println(8);
                break;
            case 7:
                System.out.println(7);
                break;
            case 6:
                System.out.println(6);
                break;
            default:
                System.out.println(0);
                break;
        }
        input.close();
    }

    public void cycling() {
        int sum = 0;
        for (int i = 1; i <= 100; i += 2) {
            sum += i;
        }
        System.out.println(sum);
    }

}
