package zrz.controller;

import java.util.Scanner;

import zrz.manager.DataProcessManager;

/**
 * 入口程序
 * 
 * @author 天亮教育-帅气多汁你泽哥
 * @Date 2023年11月2日
 */
public class SystemController {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("请输入IP地址:");
			String ip = scanner.next();
			long startTime = System.currentTimeMillis();
			String location = DataProcessManager.getLocation(ip);
			System.out.println(location);
			long endTime = System.currentTimeMillis();
			System.out.println("耗时:" + (endTime - startTime));
		}
	}
}
