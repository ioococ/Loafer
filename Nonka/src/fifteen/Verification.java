package fifteen;

import java.util.Random;

public class Verification {
	public static void main(String[] args) {
		Random random = new Random(20001008);
		char[] c = new char[4];
		System.out.println("当前验证码是：");
		for (int i = 0; i < c.length; i++) {
			c[i] = (char) ((random.nextInt(26)) + 97);
			System.out.print(c[i]);
		}
		System.out.print("请输入验证码：");
		
	}
}
