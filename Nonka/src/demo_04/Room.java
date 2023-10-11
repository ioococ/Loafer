package demo_04;

public class Room {
	private int roomNo;
	private String typeof;
	private Boolean occupy = false;

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public String getTypeof() {
		return typeof;
	}

	public void setTypeof(String typeof) {
		this.typeof = typeof;
	}

	public Boolean getOccupy() {
		return occupy;
	}

	public void setOccupy(Boolean occupy) {
		this.occupy = occupy;
	}

}
