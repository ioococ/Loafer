package collection.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@SuppressWarnings("all")
public class ListSort {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(11);
		list.add(12);
		list.add(2);
		// 使用API进行排序,会调用 元素的compareTo 方法进行排序
		Collections.sort(list);

		// 如果 要添加的元素,排序规则不符合我们需求,或,元素没有 compareTo方法,则使用Comparator
		Collections.sort(list, new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				if (o1 instanceof Integer && o2 instanceof Integer) {
					Integer i1 = (Integer) o1;
					Integer i2 = (Integer) o2;
					return i2 - i1;
				}
				return 0;
			}
		});

		// 使用集合自身的排序,需要传入 Comparator 比较器进行比较
		list.sort(new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				if (o1 instanceof Integer && o2 instanceof Integer) {
					Integer i1 = (Integer) o1;
					Integer i2 = (Integer) o2;
					return i1 - i2;
				}
				return 0;
			}
		});

		System.out.println(list);

	}
}
