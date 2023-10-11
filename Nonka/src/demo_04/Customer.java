package demo_04;

import java.util.Scanner;

public class Customer {
	public static void main(String[] args) {
		Hotel hotel = new Hotel();
		Scanner scanner = new Scanner(System.in);
		hotel.outRoom();
		while (true) {
			hotel.show();
			System.out.println("请选择操作");
			System.out.println("输入1预定");
			System.out.println("输入2退订");
			int sc = scanner.nextInt();
			if (sc != 1 && sc != 2) {
				break;
			}
			if (sc == 1) {
				hotel.reservation();
				hotel.show();
			}
			if (sc == 2) {
				hotel.tuiding();
				hotel.show();
			}

		}
	}
}
