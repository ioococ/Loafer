package collection.quiz;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author: nekotako
 * @Description: 给出一个字符串, 只包括大小写字母 计算字符串中,每个字符出现的次数,并以出现次数降序排序
 * @Date: 2023/10/19 19:34 星期四
 */

public class Sort {
    public static void main(String[] args) {
        String s = "abzxccasjlkjlexcvlphvcsddqfsdfwdasde";
        char[] charArray = s.toCharArray();
        TreeMap<Character, Integer> charMap = new TreeMap<>();
        for (int i = 0; i < charArray.length; i++) {
            if (charMap.containsKey(charArray[i])) {
                charMap.put(charArray[i], charMap.get(charArray[i]) + 1);
            } else {
                charMap.put(charArray[i], 1);
            }
        }
        // 对 charMap 进行排序
        ArrayList<Map.Entry<Character, Integer>> entries = new ArrayList<>(charMap.entrySet());
        entries.sort((o1, o2) -> o2.getValue() - o1.getValue());
        for (Map.Entry<Character, Integer> entry : entries) {
            System.out.print(entry.getKey() + "(" + entry.getValue() + ")");
        }

    }
}
