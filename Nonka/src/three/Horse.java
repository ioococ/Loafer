package three;
public class Horse {
    public static void main(String[] args) {
        for (int big = 1; big <= 33; big++)
            for (int mid = 1; mid <= 50; mid++)
                for (double small = 3; small <= 100; small++)
                    if (big * 3 + mid * 2 + small / 3 == 100) {
                        if (big + mid + small == 100 && small % 3 == 0) {
                            System.out.println("大马数:" + big + " 中马数:" + mid + " 小马数:" + small);
                        }
                    }
    }
}