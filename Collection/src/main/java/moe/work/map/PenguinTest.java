package moe.work.map;

import org.junit.Test;

import java.util.HashMap;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 2023/8/31 19:29 星期四
 */

public class PenguinTest {
    @Test
    public void main() {
        HashMap<String, String> map = new HashMap<>();

        Penguin ya = new Penguin("亚亚", "Q妹");
        Penguin fei = new Penguin("菲菲", "Q妹");
        Penguin ou = new Penguin("欧欧", "Q妹");
        Penguin mei = new Penguin("美美", "Q妹");

        map.put(ya.getName(), ya.getAlias());
        map.put(fei.getName(), fei.getAlias());
        map.put(ou.getName(), ou.getAlias());
        map.put(mei.getName(), mei.getAlias());


        for (String s : map.keySet()) {
            System.out.println(s + "\t" + map.get(s));
        }
    }
}
