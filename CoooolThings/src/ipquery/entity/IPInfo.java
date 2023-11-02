package ipquery.entity;

import ipquery.util.IPUtils;

/**
 * @Author: nekotako
 * @Description: IP信息实体类
 * @Date: 2023/11/2 18:26 星期四
 */

public class IPInfo implements Comparable<IPInfo> {
    private String startIP;
    private String endIP;
    private String location;
    private long startLong;
    private long endLong;

    public IPInfo() {
    }

    public IPInfo(String startIP, String endIP, String location) {
        this.startIP = startIP;
        this.endIP = endIP;
        this.location = location;
        this.startLong = IPUtils.ipToLong(startIP);
        this.endLong = IPUtils.ipToLong(endIP);
    }

    public String getStart() {
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

    public long getStartLong() {
        return startLong;
    }

    public void setStartLong(long startLong) {
        this.startLong = startLong;
    }

    public long getEndLong() {
        return endLong;
    }

    public void setEndLong(long endLong) {
        this.endLong = endLong;
    }

    @Override
    public String toString() {
        return "[start:" + startIP + " endIP:" + endIP + " location:" + location + "，" + startLong + "，" + endLong + ']';
    }

    // 比较起始IP的long值
    @Override
    public int compareTo(IPInfo ip) {
        long num = this.startLong - ip.startLong;
        if (num > 0)
            return 1;
        if (num < 0)
            return -1;
        return 0;
    }
}
