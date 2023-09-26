package six;

import java.util.Arrays;

public class Search {
    public Search() {
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        long stime = System.nanoTime();
        System.out.println(binarySearch(arr, 9));
        long etime = System.nanoTime();
        Arrays.sort(arr);
        System.out.println(etime - stime);
    }

    static int oneByOneSearch(int[] array, int target) {
        for (int i = 0; i < array.length; ++i) {
            if (array[1] == target) {
                return i;
            }
        }
        return -1;
    }

    static int binarySearch(int[] array, int target) {
        int startIndex = 0;
        int endIndex = array.length - 1;
        int index = (startIndex + endIndex) / 2;
        for (int i = 0; i < array.length; i++) {
            if (target > array[index]) {
                startIndex = index + 1;
            } else if (target < array[index]) {
                endIndex = index - 1;
            } else if (target == array[index]) {
                return index;
            }
            index = (startIndex + endIndex) / 2;
        }
        return -1;
    }
}
