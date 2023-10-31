package pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 2023/10/31 19:19 星期二
 */

public class RemoveDuplicates {
    public static void main(String[] args) {
        String input = "我我我、、、我我、、我、我要要、、、要要要、、要要、、学学学、、、、学学、、、学编编编、、编编编程、、程程";
        input = input.replace("、","");
        String regex = "(.)(\\1+)";
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(input);
        input = input.replaceAll(regex, "$1");
        System.out.println(input);

    }
}
