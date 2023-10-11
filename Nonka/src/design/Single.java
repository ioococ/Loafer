package design;

public class Single {
	public static void main(String[] args) throws ClassNotFoundException {
		// System.out.println(Single_01.getObj());
		// System.out.println(Single_01.getObj());
		// System.out.println(Single_02.getObj());
		// System.out.println(Single_02.getObj());
		Class.forName("design.Single_01");
		Class.forName("design.Single_02");
	}
}

/**
 * Single_01 饿汉模式
 */
class Single_01 {
	private void Single_01() {
		System.out.println("Single_01构造方法执行");
	}

	static Single_01 obj = new Single_01();

	static Single_01 getObj() {
		return obj;
	}
}

/**
 * Single_02 懒汉模式
 */
class Single_02 {
	private void Single_02() {
		System.out.println("Single_02构造方法执行");
	}

	static Single_02 obj = null;

	static Single_02 getObj() {
		if (obj == null) {
			obj = new Single_02();
		}
		return obj;
	}
}