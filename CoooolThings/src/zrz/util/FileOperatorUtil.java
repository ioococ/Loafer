package zrz.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * 读取IP地址库 并 封装到集合的工具类
 * 
 * @author 天亮教育-帅气多汁你泽哥
 * @Date 2023年11月2日
 */
public class FileOperatorUtil {
	/**
	 * 完成文本文件读取,并封装到集合中返回
	 * 
	 * @param txtFilePath
	 *            字符串格式的文件路径
	 * @param encoding
	 *            字符编码
	 * @return
	 * @throws IOException
	 */
	public static List<String> getLineList(String txtFilePath, String encoding)
			throws IOException {
		// 字节输入流
		FileInputStream fis = new FileInputStream(txtFilePath);
		// 转换为字符流并指定字符编码
		Reader reader = new InputStreamReader(fis, encoding);
		// 字符缓冲流
		BufferedReader br = new BufferedReader(reader);
		// 用于保存读取到的数据
		List<String> lineList = new ArrayList<String>();
		// 遍历读取
		String temp = null;
		while ((temp = br.readLine()) != null) {
			lineList.add(temp);
		}
		// 关闭资源
		br.close();
		return lineList;
	}
}
