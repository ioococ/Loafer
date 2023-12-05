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
     *
     * @param file     文件路径
     * @param encoding 字符编码
     * @return IP 信息字符串集合
     * @throws Exception
     */
    public static List<String> toStringList(String file, String encoding) throws IOException {
        InputStream resourceAsStream = FileUtils.class.getClassLoader().getResourceAsStream(file);
        System.out.println(FileUtils.class.getClassLoader().getResourceAsStream(file));
        // 创建文件输入流直接字节编码转换为字符输入流再转换为字符缓冲流
        BufferedReader reader = new BufferedReader(new InputStreamReader(resourceAsStream, encoding));
        // 保存读出的数据
        ArrayList<String> strings = new ArrayList<>();
        String temp = null;
        while ((temp = reader.readLine()) != null) {
            strings.add(temp);
        }
        reader.close();
        resourceAsStream.close();
        return strings;
    }


    /**
     * 实现了一个简单的序列化对象到文件中的方法
     * <p>
     * 这个方法使用了缓冲流来减少文件IO次数,提高序列化效率。
     *
     * @param object         需序列化的对象
     * @param serializedFile 序列化后输出的文件
     * @param cacheLength    缓冲流的长度
     * @throws IOException 抛出IO异常
     */
    public static void serialize(Object object, String serializedFile, int cacheLength) throws IOException {
        // 创建一个文件输出流,指向序列化后的文件
        FileOutputStream fileOutputStream = new FileOutputStream(serializedFile);
        // 创建一个字节数组输出流,用来缓存要写入文件中的字节数组
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(cacheLength);
        // 在字节数组输出流上包装一个对象输出流,用于序列化对象。
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        // 将对象通过对象输出流写入字节数组输出流。
        objectOutputStream.writeObject(object);
        objectOutputStream.flush();
        // 将字节数组输出流中的字节数组获取出来。
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        // 通过文件输出流将字节数组写入文件。
        fileOutputStream.write(byteArray);

        objectOutputStream.close();
        byteArrayOutputStream.close();
        fileOutputStream.close();
    }

    /**
     * 实现了从文件中反序列化返回对象的功能
     * <p>
     * 同样使用了缓冲字节数组,为了减少文件读取次数,提高效率
     *
     * @param serializedFile 序列化产生的文件
     * @param cacheLength    缓冲流的长度
     * @return 返回被反序列的对象
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Object deserialize(String serializedFile, int cacheLength) throws IOException, ClassNotFoundException {
        // 创建一个文件输入流,从指定文件中读取字节数据
        FileInputStream fileInputStream = new FileInputStream(serializedFile);
        // 创建一个字节数组,用于缓存从文件中读取的字节数据
        byte[] byteArray = new byte[cacheLength];
        // 通过文件输入流读取文件数据到字节数组中
        fileInputStream.read(byteArray);
        fileInputStream.close();
        // 用字节数组构造一个字节数组输入流
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
        // 在字节数组输入流上构造一个对象输入流
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        // 从对象输入流中读取一个对象并返回
        return objectInputStream.readObject();
    }
}
