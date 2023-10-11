package leetcode;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 2023/10/9 9:51 星期一
 */

public class MergeArrays {
    public MergeArrays() {
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        nums1 = merge(nums2, nums1, 3, 3);

        for(int i = 0; i < nums1.length; ++i) {
            System.out.print(nums1[i] + " ");
        }

    }

    static int[] merge(int[] originArrays, int[] targetArrays, int originIndex, int targetIndex) {
        targetArrays = bubbleSort(targetArrays);

        for(int i = 0; i < originArrays.length; ++i) {
            targetArrays[i] = originArrays[i];
        }

        targetArrays = bubbleSort(targetArrays);
        return targetArrays;
    }

    static int[] bubbleSort(int[] arr) {
        for(int i = 1; i < arr.length; ++i) {
            boolean flag = true;

            for(int j = 0; j < arr.length - i; ++j) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    flag = false;
                }
            }

            if (flag) {
                break;
            }
        }

        return arr;
    }
}

