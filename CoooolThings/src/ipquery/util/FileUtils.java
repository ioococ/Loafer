package ipquery.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: nekotako
 * @Description: 文件处理工具类
 * @Date: 2023/11/2 18:57 星期四
 */

public class FileUtils {
    /**
     * 读取文件内容，并将其中每一行 IP 信息转换为字符串集合
     * @param file 文件路径
     * @param encoding 字符编码
     * @return IP 信息字符串集合
     * @throws Exception
     */
    public static List<String> toStringList(String file, String encoding) throws IOException {
        // 创建文件输入流直接字节编码转换为字符输入流再转换为字符缓冲流
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), encoding));
        // 保存读出的数据
        ArrayList<String> strings = new ArrayList<>();
        String temp = null;
        while ((temp = reader.readLine()) != null){
            strings.add(temp);
        }
        return strings;
    }
}
