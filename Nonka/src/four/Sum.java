package four;

public class Sum {
    public static void main(String[] args) {
        System.out.println(sum(10));
    }

    static int sum(int num) {
        if (num == 1) {
            return 1;
        }
        System.out.println(num);
        return num + sum(num - 1);
    }
}
