package set;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Tree {
	public static void main(String[] args) {
		HashSet<Object> tree = new HashSet<>();
		tree.add('a');
		tree.add(2);
		tree.add(3);
		tree.add('z');
		tree.add(5);
		System.out.println(tree);
	}
}
