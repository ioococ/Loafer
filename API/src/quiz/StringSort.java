package quiz;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * @Author: nekotako
 * @Description: String默认按照每位ASCII进行排序,要求按照对应的数值大小进行排序
 * @Date: 2023/10/19 16:41 星期四
 */

public class StringSort {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("10");
        list.add("12");
        list.add("3");
        TreeSet<String> strings = new TreeSet<>(list);
        // 1 10 12 2 3
        list = new ArrayList<>(strings);
        System.out.println(strings);
        list.sort((o1, o2) -> Integer.parseInt(o1) - Integer.parseInt(o2));
        // TODO 在这里加入一些代码使下面的输出变成 1 2 3 10 12(不能删除数据和新增数据)
        System.out.println(list);
    }
}
