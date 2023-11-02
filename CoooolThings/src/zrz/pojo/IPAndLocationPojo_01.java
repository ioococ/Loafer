package zrz.pojo;

/**
 * 结构化抽象类
 * 
 * @author 天亮教育-帅气多汁你泽哥
 * @Date 2023年11月2日
 */
public class IPAndLocationPojo_01 {
	/**
	 * 起始IP
	 */
	private String startIP;
	/**
	 * 结束IP
	 */
	private String endIP;
	/**
	 * 归属地
	 */
	private String location;

	public String getStartIP() {
		return startIP;
	}

	public void setStartIP(String startIP) {
		this.startIP = startIP;
	}

	public String getEndIP() {
		return endIP;
	}

	public void setEndIP(String endIP) {
		this.endIP = endIP;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public IPAndLocationPojo_01(String startIP, String endIP, String location) {
		super();
		this.startIP = startIP;
		this.endIP = endIP;
		this.location = location;
	}

	@Override
	public String toString() {
		return "IPAndLocationPojo [startIP=" + startIP + ", endIP=" + endIP
				+ ", location=" + location + "]";
	}

	public IPAndLocationPojo_01() {
		super();
	}

}
