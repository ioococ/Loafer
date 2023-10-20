package generics;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Generics {
    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<>();
        map.put("a", 123);
        map.put("b", 61);
        map.put("c", 33);
        map.put("d", 48);
        map.put("e", 49);
        map.put("f", 1);
        map.put("g", 21);
        map.put("h", 11);
        map.put("i", 4);
        Set<Entry<String, Integer>> entrySet = map.entrySet();
        ArrayList<Entry<String, Integer>> entries = new ArrayList<>(entrySet);
        entries.sort((o1, o2) -> o1.getValue() - o2.getValue());
        System.out.println(entries);
    }
}
