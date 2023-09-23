public class THIS {
    int d;

    public static void main(String[] args) {
        THIS b = new THIS();
        b.c();
    }

    public void c() {
        int d = 1;
        System.out.println(this.d);
        System.out.println(d);
    }
}