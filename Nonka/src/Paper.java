public class Paper {
    public static void main(String[] args) {
        int mountainHeight = 8848;
        double paperHeight = 0.01;
        int i = 1;
        for (; paperHeight <= mountainHeight; i++)
            paperHeight = paperHeight * 2;
        System.out.println("折叠" + (i - 1) + "次，就可以保证厚度不低于珠穆朗玛峰的高度");
    }
}
