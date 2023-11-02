package ipquery;

import ipquery.entity.IPInfo;
import ipquery.service.DataProcess;
import ipquery.util.FileUtils;
import ipquery.util.IPUtils;

import java.io.IOException;
import java.util.List;

import static ipquery.util.IPUtils.ipToLong;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 2023/11/2 18:25 星期四
 */

public class Main {
    public static void main(String[] args) {
        List list = null;
        try {
            list = FileUtils.toStringList("./CoooolThings/resources/ip_location_relation.txt", "utf-8");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        IPInfo[] ipInfoArray = DataProcess.toIPInfoArray(list);
        DataProcess dataProcess = new DataProcess();
        long l = IPUtils.ipToLong("1.0.32.128");
        IPInfo ipInfo = dataProcess.dichotomousQuery(ipInfoArray, l);
        System.out.println(ipInfo.getLocation());
    }
}
