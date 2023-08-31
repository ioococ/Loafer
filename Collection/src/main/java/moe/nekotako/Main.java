package moe.nekotako;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: ${DATE} ${TIME} ${DAY_NAME_FULL}
 */

public class Main {
    @Test
    public void main() {
        Map<Object, Object> map = new HashMap<>();
        map.put("aa", "Apple");
        map.put("bb", "pineapple");
        map.put("cc", "banana");
        map.put("dd", "eggplant");

        int i = 10;
        Integer j = 10;
        Integer k = i;
        Integer l = j;
        System.out.println(j.getClass() + "@" + j.hashCode());
        System.out.println(l.getClass() + "@" + l.hashCode());
    }
}