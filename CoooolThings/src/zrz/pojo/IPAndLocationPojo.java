package zrz.pojo;

import zrz.util.IPUtil;

/**
 * 结构化抽象类
 * 
 * @author 天亮教育-帅气多汁你泽哥
 * @Date 2023年11月2日
 */
public class IPAndLocationPojo implements Comparable<IPAndLocationPojo> {
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

	private long startIPLong;
	private long endIPLong;

	public long getStartIPLong() {
		return startIPLong;
	}

	public void setStartIPLong(long startIPLong) {
		this.startIPLong = startIPLong;
	}

	public long getEndIPLong() {
		return endIPLong;
	}

	public void setEndIPLong(long endIPLong) {
		this.endIPLong = endIPLong;
	}

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

	public IPAndLocationPojo(String startIP, String endIP, String location) {
		super();
		this.startIP = startIP;
		this.endIP = endIP;
		this.location = location;
		this.startIPLong = IPUtil.ipToLong(startIP);
		this.endIPLong = IPUtil.ipToLong(endIP);
	}

	@Override
	public int compareTo(IPAndLocationPojo o) {
		long result = this.startIPLong - o.startIPLong;
		// return result > 0 ? 1 : (result < 0 ? -1 : 0);
		if (result > 0) {
			return 1;
		} else if (result < 0) {
			return -1;
		} else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return "IPAndLocationPojo [startIP=" + startIP + ", endIP=" + endIP
				+ ", location=" + location + ", startIPLong=" + startIPLong
				+ ", endIPLong=" + endIPLong + "]";
	}

	public IPAndLocationPojo() {
		super();
	}
}
