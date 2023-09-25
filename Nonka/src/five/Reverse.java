package five;

public class Reverse {
    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6, 7 };
        for (int i = 0; i < array.length; i++) {
            System.out.print(reverse(array)[i]);
        }
    }

    static int[] reverse(int[] arr) {
        int a;
        for (int i = (arr.length) / 2; i >= 0; i--) {
            a = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - 1] = a;
        }
        return arr;
    }
}
