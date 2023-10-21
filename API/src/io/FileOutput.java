package io;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class FileOutput{
    public static void main(String[] args) throws IOException {
        FileOutput fileOutput = new FileOutput();
        fileOutput.fileWriter();
    }
    public void fileWriter() throws IOException{
        FileWriter fileWriter = new FileWriter("./API/src/io/test");
        fileWriter.write("apple");
        fileWriter.flush();
        fileWriter.close();
    }
    public void fileOutputStream() throws IOException{
        FileOutputStream fileOutputStream = new FileOutputStream("null");
		fileOutputStream.write(97);
		byte[] bytes = { 97, 98, 99, 100, 101, 102 };
		fileOutputStream.write(bytes);
		fileOutputStream.write(bytes, 0, 3);
		// 没有提供写出字符串的方法,想要写出字符串需要先转换为字节数组
		bytes = "你好吗?".getBytes();
		fileOutputStream.write(bytes);
		fileOutputStream.flush();
		fileOutputStream.close();
    }
}
