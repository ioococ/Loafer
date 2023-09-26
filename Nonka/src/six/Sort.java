package six;

public class Sort {
    public static void main(String[] args) {
        int[] oldArr = { 7, 5, 6, 9, 3, 2, 33, 56, 93, 12, 1, 0 };
        selectSort(oldArr);
    }

    static void selectSort(int[] arr) {
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        for (int i = 0; i < newArr.length; i++) {

            for (int k = 0; k < newArr.length; k++) {
                System.out.print(newArr[k] + " ");
            }
            System.out.println();


            // 当前循环中的最小值
            int minVal = newArr[i];
            // 当前循环中的最大值
            int maxVal = 0;
            for (int j = i; j < newArr.length; j++) {
                // 如果当前最小值大于遍历时获得的值 则将当前值赋给最小值
                // 并交换顺序
                if (minVal > newArr[j]) {
                    minVal = newArr[j];

                    maxVal = newArr[i];
                    newArr[i] = minVal;
                    newArr[j] = maxVal;
                }
            }
        }
    }
}
