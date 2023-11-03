package ipquery;

import ipquery.entity.IPInfo;
import ipquery.service.DataProcess;
import ipquery.util.FileUtils;
import ipquery.util.IPUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static ipquery.Common.*;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 2023/11/2 18:25 星期四
 */

public class Main {
    static List<String> list = null;
    static IPInfo[] ipInfoArray = null;

    static {
        long l = System.currentTimeMillis();
        if (!new File(SERIALIZED_FILE).exists()) {
            try {
                list = FileUtils.toStringList(IP_INFO_FILE, ENCODING);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            ipInfoArray = DataProcess.toIPInfoArray(list);
        } else {
            try {
                ipInfoArray = (IPInfo[]) FileUtils.deserialize(SERIALIZED_FILE, CACHE_LENGTH);
            } catch (ClassNotFoundException | IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("程序初始化完成");
        }
    }

    public static void main(String[] args) {
        DataProcess dataProcess = new DataProcess();
        Scanner input = new Scanner(System.in);
        System.out.print("请输入IP地址：");
        String ip = input.nextLine();
        String regex = "^((25[0-5]|(2[0-4]|1\\d|[1-9]|)\\d)\\.?\\b){4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ip);
        if (matcher.matches()) {
            long l = IPUtils.ipToLong(ip);
            IPInfo ipInfo = dataProcess.dichotomousQuery(ipInfoArray, l);
            System.out.println(ipInfo.getLocation());
        } else {
            System.err.println("IP输入错误");
        }
    }
}
