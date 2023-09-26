package five;

public class Reverse {
    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6, 7 };
        reverse(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");

        }
    }

    // 数组为传址方式 无需返回值
    static void reverse(int[] arr) {
        int a;
        for (int i = (arr.length - 1); i >= arr.length / 2; i--) {
            a = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = a;
        }
    }
}
