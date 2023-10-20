package quiz;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * @Author: nekotako
 * @Description: 杨辉三角, 使用Map和List实现
 * @Date: 2023/10/19 16:52 星期四
 */

@SuppressWarnings({"unchecked"})
public class Triangle {
    public static void main(String[] args) {
        TreeMap<Integer, ArrayList<Integer>> triangle = new TreeMap<>();
        for (int i = 1; i < 11; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            if (i == 1)
                list.add(1);
            else if (i == 2) {
                list.add(1);
                list.add(1);
            } else {
                for (int j = 0; j <= i - 1; j++) {
                    if (j == 0 || j == i - 1)
                        list.add(1);
                    else {
                        ArrayList<Integer> temp = triangle.get(i - 1);
                        list.add(temp.get(j) + temp.get(j - 1));
                    }
                }
            }
            triangle.put(i, list);
        }
        System.out.println(triangle);
    }
}
