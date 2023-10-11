package hotel;

import java.util.Scanner;

public class Run {

    static Hotel m = new Hotel();
    static Room[][] room;

    public static void main(String[] args) {
        Run run = new Run();
        room = m.createHotal(5, 10);
        while (true) {
            System.out.println("----------酒店预订系统-----------");
            run.infoPrint();
            System.out.println("---------------------------------");
            Scanner input = new Scanner(System.in);
            System.out.print("请输入操作格式为 预订 101  /  退订 201: ");
            String operate = input.nextLine();
            String[] s = operate.split(" ");
            if (s[0].equals("预订")) {
                System.out.println(Integer.parseInt(s[1]));
                m.booking(Integer.parseInt(s[1]));
            } else if ((s[0].equals("退订"))) {
                m.cancel(Integer.parseInt(s[1]));
                System.out.println(Integer.parseInt(s[1]));
            } else
                break;
        }
    }

    void infoPrint() {
        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room[i].length; j++) {
                System.out.print(room[i][j]);
            }
            System.out.println();
        }
    }
}
