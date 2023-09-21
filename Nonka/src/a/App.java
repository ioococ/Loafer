package a;

import java.util.ArrayList;
import java.util.List;

public class App {
    int i;
    static int a = 1;

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        String s = "我的世界";
        // for (int i = 0; i < s.length(); i++) {
        // System.out.println(s.charAt(i));
        // }

        // char c = '\u7682';
        // s = (String) c;
        // s = String.valueOf(c);

        // byte b = (byte) 128;
        // System.out.println((float) (0.1 + 0.2));
        int i = 1;

        // App app = new App();
        // System.out.println(app.i);

        // System.out.println(10 / 3.0F);
        int x = 3;
        int y = x + x++ + ++x + ++x + x++ + x;
        System.out.println(y);
    }

    public void app() {
        int i = 0;
        System.out.println(i);
    }
}

/**
 * InnerApp
 */
class InnerApp {
    int i;

    public void app() {
        System.out.println();
    }
}
