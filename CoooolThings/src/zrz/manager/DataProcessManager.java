package zrz.manager;

import zrz.pojo.IPAndLocationPojo;
import zrz.util.FileOperatorUtil;
import zrz.util.IPUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 该类为项目的数据处理管理类,用来衔接各个模块的输入输出,进行有机组合
 *
 * @author 天亮教育-帅气多汁你泽哥
 * @Date 2023年11月2日
 */
public class DataProcessManager {
    static IPAndLocationPojo[] ipAndLocationPojoArray = null;

    static {
        String filePath = "ip_location_relation.txt";
        String encoding = "utf-8";
        List<IPAndLocationPojo> ipAndLocationPojos = null;
        ipAndLocationPojoArray = null;
        try {
            ipAndLocationPojos = getPojoList(filePath, encoding);
            ipAndLocationPojoArray = convertListToArrayAndSore(ipAndLocationPojos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 对外提供的接口API , 根据IP获取归属地
     *
     * @param ip
     * @return
     */
    public static String getLocation(String ip) {

        // 二分法查询获取索引
        int index = binaraySearchIPAndLocationPojo(ipAndLocationPojoArray, ip);
        // 判断是否查询到,如果没有则返回null
        if (index == -1) {
            return null;
        }
        return ipAndLocationPojoArray[index].getLocation();
    }

    /**
     * 业务类对应的二分法查询
     *
     * @param ipAndLocationPojos 结构化并排序之后的数组
     * @param target             目标IP
     * @return
     */
    public static int binaraySearchIPAndLocationPojo(IPAndLocationPojo[] ipAndLocationPojos, String target) {
        int startIndex = 0;
        int endIndex = ipAndLocationPojos.length - 1;
        int m = (startIndex + endIndex) / 2;
        // 转换long类型
        long ipLong = IPUtil.ipToLong(target);
        while (startIndex <= endIndex) {
            if (ipLong >= ipAndLocationPojos[m].getStartIPLong()&& ipLong <= ipAndLocationPojos[m].getEndIPLong()) {
                return m;
            } else if (ipLong < ipAndLocationPojos[m].getStartIPLong()) {
                // 目标数据小于中间数据时,起始索引不变,结束索引 = 中间索引-1
                endIndex = m - 1;
            } else if (ipLong > ipAndLocationPojos[m].getEndIPLong()) {
                // 目标数据大于中间数据时,结束索引不变,起始索引=中间索引+1
                startIndex = m + 1;
            }
            m = (startIndex + endIndex) / 2;
        }
        return -1;
    }

    /**
     * 将对象集合转换为数组,并排序
     *
     * @param ipAndLocationPojos
     * @return
     */
    public static IPAndLocationPojo[] convertListToArrayAndSore(List<IPAndLocationPojo> ipAndLocationPojos) {
        // 转换为数组
        IPAndLocationPojo[] arr = new IPAndLocationPojo[ipAndLocationPojos.size()];
        ipAndLocationPojos.toArray(arr);
        // 排序
        Arrays.sort(arr);
        return arr;
    }

    /**
     * 进行数据结构化,返回List<IPAndLocationPojo>
     *
     * @param filePath 文件路径
     * @param encoding 字符编码
     * @return
     * @throws IOException
     */
    public static List<IPAndLocationPojo> getPojoList(String filePath,String encoding) throws IOException {

        // 保存结构化数据
        List<IPAndLocationPojo> ipAndLocationPojos = new ArrayList<IPAndLocationPojo>();
        List<String> lineList = FileOperatorUtil.getLineList(filePath, encoding);
        for (String line : lineList) {
            // 文本文件中出现空行的情况还是比较多的,所以进行一次空行校验,提高健壮性
            if (line == null || line.trim().equals("")) {
                continue;
            }
            // 防止有有多个\t在一起,导致分割后个数不一致
            // 把多个\t替换成一个\t即可
            line = line.replaceAll("\t+", "\t");
            // 拆分数据行
            String[] cols = line.split("\t");
            // 获取每列数据
            // 封装到对象中
            IPAndLocationPojo ipAndLocationPojo = new IPAndLocationPojo(
                    cols[0], cols[1], cols[2]);
            // 把对象保存在集合中
            ipAndLocationPojos.add(ipAndLocationPojo);
        }
        return ipAndLocationPojos;
    }
}
