package leetcode;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 2023/10/9 9:54 星期一
 */

public class Plus {
    public Plus() {
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9, 9};
        arr = plus(arr);
    }

    static int[] plus(int[] array) {
        for(int i = array.length - 1; i >= 0; --i) {
            if ((array[i] = ++array[i] % 10) != 0) {
                return array;
            }
        }

        array = new int[array.length + 1];
        array[0] = 1;
        return array;
    }
}

