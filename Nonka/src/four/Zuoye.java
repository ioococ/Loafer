package four;

public class Zuoye {
    public static void main(String[] args) {
        // 1.n的阶乘
        /*
         * int result = factorial(3);
         * System.out.println(result);
         */

        // 2.递归求1+2+3+…+10
        /*
         * int result1 = sum(3);
         * System.out.println(result1);
         */

        // 3.按顺序打印一个数字的每一位(例如1234 打印出1 2 3 4)
        /* obtainBit(1234); */

        // 4.实现代码:写一个递归方法,输入一个非负整数,返回组成它的数字之和
        /*
         * int result = numSum(1234);
         * System.out.println(result);
         */

        // 5.判断传递的参数值在斐波那契数列的第几位上
        /*
         * int result = findFibonacciIndex(5);
         * System.out.println(result);
         */

        // 方法联系
        /* eq(1,1); */

        /* zhishu(3); */

    }

    // n的阶乘
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    // 递归求1+2+3+…+10
    public static int sum(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sum(n - 1);
    }

    // 按顺序打印一个数字的每一位(例如1234 打印出1 2 3 4)
    public static void obtainBit(int a) {
        if (a <= 9) {
            System.out.println(a);
            return;
        }
        int m = a % 10;
        int x = a / 10;
        obtainBit(x);
        System.out.println(m);
    }

    // 实现代码:写一个递归方法,输入一个非负整数,返回组成它的数字之和
    public static int numSum(int n) {
        if (n <= 9) {
            return n;
        }
        int m = n % 10;
        int x = n / 10;
        return m + numSum(x);
    }

    // 判断传递的参数值在斐波那契数列的第几位上
    public static int findFibonacciIndex(int num) {
        if (num < 0) {
            return -1;
        }
        return findFibonacciIndexRecursive(num, 0, 1, 1);
    }

    private static int findFibonacciIndexRecursive(int num, int a, int b, int index) {
        if (a == num) {
            return index;
        } else if (a > num) {
            return -1;
        } else {
            return findFibonacciIndexRecursive(num, b, a + b, index + 1);
        }
    }

    // 方法作业
    public static void eq(int x, long y) {
        if (x == y) {
            System.out.println("相等");
        } else {
            System.out.println("不相等");
        }
    }

    // 判断是否为质数
    public static void zhishu(int n) {
        int i = 2;
        for (; i < n; i++) {
            if (n % i == 0) {
                System.out.println(n + "不是质数");
                break;
            }
        }
        if (i == n) {
            System.out.println(n + "是质数");
        }

    }

}
