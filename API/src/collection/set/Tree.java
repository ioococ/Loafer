package collection.set;

import java.util.TreeSet;

public class Tree {
	public static void main(String[] args) {
		TreeSet<Object> tree = new TreeSet<>();
		tree.add(new User("张三",18));
		tree.add(new User("李四",13));
		tree.add(new User("王五",32));
		tree.add(new User("赵六",11));
		System.out.println(tree);
	}
}
