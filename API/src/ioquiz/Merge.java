package ioquiz;

import java.io.*;
/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 2023/10/23 19:00 星期一
 */
public class Merge {
    public static void main(String[] args) throws IOException {
        Merge m = new Merge();
        File[] files = new File[3];
        files[0] = new File("./resources/one.txt");
        files[1] = new File("./resources/two.txt");
        files[2] = new File("./resources/three.txt");
        for (int i = 0; i < files.length; i++) {
            m.merge(files[i], new File("./resources/merge.txt"));
        }
    }

    public boolean merge(File sourceFile, File targetFile) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(sourceFile);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        FileOutputStream fileOutputStream = new FileOutputStream(targetFile, true);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        byte[] bytes = new byte[bufferedInputStream.available()];
        int temp = 0;
        while ((temp = bufferedInputStream.read(bytes)) != -1) {
            bufferedOutputStream.write(bytes, 0, temp);
            bufferedOutputStream.write("\n".getBytes());
            bufferedOutputStream.flush();
            System.out.println(sourceFile.getName()+" 写入完成");
        }
        bufferedInputStream.close();
        fileInputStream.close();
        bufferedOutputStream.close();
        fileOutputStream.close();
        return true;
    }
}
