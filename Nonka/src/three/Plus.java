package three;
public class Plus {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 100; i++)
            sum += i;
        System.out.println("1-100之间的加和是" + sum);
        System.out.println("1-100之间的所有奇数和是" + (sum / 2 - 25));
    }
}
