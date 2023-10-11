package demo_04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hotel {
	private int floor = 5;
	List<Room> list = new ArrayList<Room>();

	// 初始化
	public void outRoom() {

		for (int i = 1; i <= floor; i++) {

			for (int j = 1; j <= 10; j++) {

				Room r = new Room();
				list.add(r);
				r.setRoomNo(i * 100 + j);
				if (i == 1 || i == 2) {
					r.setTypeof("标准间");
				}
				if (i == 3 || i == 4) {
					r.setTypeof("双人间");
				}
				if (i == 5) {
					r.setTypeof("豪华间");
				}

			}

		}
	}

	// 展示
	public void show() {
		for (int i = 0; i < list.size(); i++) {
			Room eRoom = list.get(i);
			System.out.print(eRoom.getRoomNo() + "  " + eRoom.getTypeof()
					+ "  " + eRoom.getOccupy());
			if (i != 0 && i % 10 == 0) {
				System.out.println();
			}
		}
	}

	// 预定房间，根据房间号预定房间
	public void reservation() {
		System.out.println("请输入房间号：");
		Scanner scanner = new Scanner(System.in);
		int no = scanner.nextInt();
		for (int i = 0; i < list.size(); i++) {
			Room eRoom = list.get(i);
			if (eRoom.getRoomNo() == no) {
				eRoom.setOccupy(true);
				System.out.println(eRoom.getOccupy());
			}
		}

	}

	// 退订
	public void tuiding() {
		System.out.println("请输入房间号：");
		Scanner scanner = new Scanner(System.in);
		int no = scanner.nextInt();
		for (int i = 0; i < list.size(); i++) {
			Room eRoom = list.get(i);
			if (eRoom.getRoomNo() == no) {
				eRoom.setOccupy(false);
				System.out.println(eRoom.getOccupy());
			}
		}

	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

}
