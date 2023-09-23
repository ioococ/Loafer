package three;
public class Cash {
    public static void main(String[] args) {
        int day = 1;
        double sum = 0;
        for (; sum <= 100; day++) {
            sum += 2.5;
            if (day % 5 == 0) {
                sum -= 6;
            }
            // System.out.println(day + "----->" + sum);
        }
        System.out.println("共花了" + (day - 1) + "天存储了100元");
    }
}
