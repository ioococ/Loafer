package innerclass;

public class OuterClass {
	int b = 1;
	public static void main(String[] args) {
		
	}
	public void method(){
		int a = 1;
		class InnerClass {
			public void me(){
				System.out.println(a);
				System.out.println(b);
			}
		}
	}
}
