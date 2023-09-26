package five;

import org.junit.Test;

public class Arrays {
    public static void main(String[] args) {
        System.out.println(args.length);
    }
    @Test
    public void arrays(){
        int[] a = {1,2,3,4,5};
        a = new int[6];
        // a = null;
        System.out.println(a[0]);
        NullPointerException n = new NullPointerException("null");
        n.getClass();
    }
}
