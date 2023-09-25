package five;

public class Scores {
    public static void main(String[] args) {
        double[] scores = { 55.5, 65.8, 78.4, 99, 100, 95.4, 65, 98, 78, 90 };
        System.out.println("最高分数: "+maxValue(scores));
        System.out.println("最低分数: "+minValue(scores));
        System.out.println("总分: "+sumValue(scores));
        System.out.println("平均分: "+avgValue(scores));
        System.out.println("成绩大于80分的人: "+num(scores));

    }

    static double maxValue(double[] array) {
        double maxVal = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > maxVal) {
                maxVal = array[i];
            }
        }
        return maxVal;
    }

    static double minValue(double[] array) {
        double minVal = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < minVal) {
                minVal = array[i];
            }
        }
        return minVal;
    }

    static double sumValue(double[] array) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    static double avgValue(double[] array) {
        return sumValue(array) / array.length;
    }

    static int num(double[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 80) {
                sum += 1;
            }
        }
        return sum;
    }
}
