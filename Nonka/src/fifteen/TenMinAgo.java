package fifteen;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TenMinAgo {
	public static void main(String[] args) {

		Date nowDate = new Date();
		Date tenMinAgo = new Date(nowDate.getTime() - 6000 * 10 * 10);
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		// 转换时区 设置东八时
		dateFormat.setTimeZone(TimeZone.getTimeZone("Etc/GMT-8"));
		System.out.println("当前时间为：" + dateFormat.format(nowDate));
		System.out.println("十分钟前为：" + dateFormat.format(tenMinAgo));
	}
}
