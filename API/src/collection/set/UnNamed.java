package collection.set;

import java.util.Comparator;
import java.util.TreeSet;

@SuppressWarnings("all")
public class UnNamed {
	public static void main(String[] args) {
		// TreeSet<Object> tree = new TreeSet<>(new MyComparator());
		TreeSet<Object> tree = new TreeSet<>(new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				if (o1 instanceof Integer && o2 instanceof Integer) {
					// o1 是要添加的元素
					// System.out.println(o1);
					// o2 是集合中的元素
					// System.out.println(o2);

					Integer i1 = (Integer) o1;
					Integer i2 = (Integer) o2;
					// 10-9 降序排列
					return i2 - i1;
				}
				return 0;
			}
		});
		tree.add(11);
		tree.add(7611);
		tree.add(1);
		tree.add(100);
		tree.add(660);
		tree.add(98);
		System.out.println(tree);
	}
}

class MyComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		if (o1 instanceof Integer && o2 instanceof Integer) {
			// o1 是要添加的元素
			// System.out.println(o1);
			// o2 是集合中的元素
			// System.out.println(o2);

			Integer i1 = (Integer) o1;
			Integer i2 = (Integer) o2;
			// 10-9 降序排列
			return i2 - i1;
		}
		return 0;
	}
}
