package list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Test {
	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<>();
		LinkedList<Integer> linked = new LinkedList<>();
		Iterator<Integer> it = array.iterator();
		linked.set(0, 123);
		linked.size();
		it.remove();
		it.hasNext();

	}
}
