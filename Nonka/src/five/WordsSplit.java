package five;

public class WordsSplit {
    public static void main(String[] args) {
        String string = "Hello World Minecraft google alphabet";
        toCharArr(string);
    }

    static int toCharArr(String str) {

        if (str == null)
            return 0;
        int start = 0, end = 0, res = 0;
        while (end < str.length()) {
            while (end < str.length() && str.charAt(end) != ' ') {
                end++;
            }
            if (start != end) {
                res = end - start;
            }
            end++;
            start = end;
        }
        return res;
    }
}
