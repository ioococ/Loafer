package ipquery.service;

import ipquery.entity.IPInfo;
import ipquery.util.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static ipquery.Common.CACHE_LENGTH;
import static ipquery.Common.SERIALIZED_FILE;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 2023/11/2 18:56 星期四
 */

public class DataProcess {

    /**
     * 进行数据处理，将IP信息字符串集合转换为IP信息数组
     *
     * @param stringList IP信息字符串数组
     * @return IP信息数组
     */
    public static IPInfo[] toIPInfoArray(List<String> stringList) {
        IPInfo[] ipInfos = new IPInfo[stringList.size()];
        ArrayList<IPInfo> ipInfoList = new ArrayList<>();
        for (String s : stringList) {
            s = s.replaceAll("\t+", "\t");
            String[] strings = s.split("\t");
            IPInfo ipInfo = new IPInfo(strings[0], strings[1], strings[2]);
            ipInfoList.add(ipInfo);
        }
        ipInfoList.toArray(ipInfos);
        if (!new File(SERIALIZED_FILE).exists()) {
            try {
                FileUtils.serialize(ipInfos, SERIALIZED_FILE, CACHE_LENGTH);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return ipInfos;
    }

    /**
     * @param array  被查找的数组
     * @param ipLong 要查找的数据
     * @return 返回IP信息对象
     */
    public IPInfo dichotomousQuery(IPInfo[] array, long ipLong) {
        int startIndex = 0;
        int endIndex = array.length - 1;
        int midIndex = (endIndex + startIndex) / 2;
        while (!(startIndex > endIndex)) {
            // 要找的值比中间值小，末尾值向前移动
            if (ipLong < array[midIndex].getStartLong()) {
                endIndex = midIndex - 1;
            } else
                // 要找的值比中间值大，起始值向后移动
                if (ipLong > array[midIndex].getEndLong()) {
                    startIndex = midIndex + 1;
                } else if (ipLong >= array[midIndex].getStartLong() && ipLong <= array[midIndex].getEndLong()) {
                    return array[midIndex];
                }
            midIndex = (endIndex + startIndex) / 2;
        }
        return null;
    }
}
