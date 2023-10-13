package hotel;

public class Hotel {
    Room[][] list;

    // public Methods(int floor, int door) {
    // 	createHotal(floor, door);
    // }

    public Room[][] createHotel(int floor, int door) {
        list = new Room[floor][door];
        for (int i = 0; i < list.length; i++) {
            int id = 1;
            if (i < 2) {
                for (int j = 0; j < list[i].length; j++) {
                    list[i][j] = new Room(i + 1, id++, 1, false);
                }
            } else if (i >= 2 && i < 4) {
                for (int j = 0; j < list[i].length; j++) {
                    list[i][j] = new Room(i + 1, id++, 2, false);
                }
            } else {
                for (int j = 0; j < list[i].length; j++) {
                    list[i][j] = new Room(i + 1, id++, 3, false);
                }
            }
        }
        return list;
    }

    public void booking(int room) {
        int floor = room / 100 - 1;
        int door = room % 100 - 1;
        if (!list[floor][door].isStatus()) {
            list[floor][door].setStatus(true);
            System.out.println("预订" + room + "成功");
        } else {
            System.out.println("预订" + room + "失败");
        }
    }

    public void cancel(int room) {
        int floor = room / 100 - 1;
        int door = room % 100 - 1;
        if (list[floor][door].isStatus()) {
            list[floor][door].setStatus(false);
            System.out.println("退订" + room + "成功");
        } else {
            System.out.println("退订" + room + "失败");
        }
    }
}
