package hotel;

public class Room {
    private int floor;
    private int id;
    private int type;
    private boolean status;

    public Room() {
    }

    /**
     * @param floor  楼层号
     * @param id     房间号
     * @param type   房间类型
     *               1-标准间 2-双人间 3-豪华间
     * @param status 房间状态
     */
    public Room(int floor, int id, int type, boolean status) {
        this.floor = floor;
        this.id = id;
        this.type = type;
        this.status = status;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        String content = null;
        String level = null;
        String occupied = null;
        if (type == 1) {
            level = "标准间";
        } else if (type == 2) {
            level = "双人间";
        } else if (type == 3) {
            level = "豪华间";
        }

        if (status)
            occupied = "占用";
        else
            occupied = "空闲";

        if (id < 10)
            content = " [" + floor + "0" + id + " " + level + " " + occupied + "] ";
        else
            content = " [" + floor + "" + id + " " + level + " " + occupied + "] ";
        return content;
    }

}
