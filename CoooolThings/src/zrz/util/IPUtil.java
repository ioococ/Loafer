package zrz.util;

/**
 * IP和long类型相互转换
 * 
 * @author 天亮教育-帅气多汁你泽哥
 * @Date 2023年11月2日
 */
public class IPUtil {

	public static void main(String[] args) {
		String ipv4Str = "16.254.22.5";
		long ipl = ipToLong(ipv4Str);
		System.out.println("ip转long：" + ipl);
		String ips = longToIp(ipl);
		System.out.println("long转ip：" + ips);
	}

	/**
	 * ipv4 的IP地址转为长整型数字
	 * 
	 * @param ipv4Str
	 * @return
	 */
	public static long ipToLong(String ipv4Str) {
		String[] temp = ipv4Str.split("\\.");
		long iplong = (Long.valueOf(temp[0]) << 24)
				+ (Long.valueOf(temp[1]) << 16) + (Long.valueOf(temp[2]) << 8)
				+ Long.valueOf(temp[3]);
		return iplong;
	}

	/**
	 * 长整型数字转为ip地址（ipv4）
	 * 
	 * @param ipv4Long
	 * @return
	 */
	public static String longToIp(long ipv4Long) {
		StringBuilder sb = new StringBuilder();
		sb.append(ipv4Long >>> 24).append(".").append((ipv4Long >>> 16) & 0xFF)
				.append(".").append((ipv4Long >>> 8) & 0xFF).append(".")
				.append(ipv4Long & 0xFF);

		return sb.toString();
	}
}