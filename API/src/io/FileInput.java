package io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class FileInput {
    public static void main(String[] args) throws IOException {
        FileInput fileInput = new FileInput();
        long startTime = System.currentTimeMillis();
        fileInput.fileInputStream();
        // fileInput.fileReader();
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }

    public void fileReader() throws IOException {
        FileReader fileReader = new FileReader("./API/src/io/FileInput.java");
        char[] buffer = new char[1024];
        int read = 0;
        while ((read = fileReader.read(buffer)) != -1) {
            System.out.println(new String(buffer, 0, read));
        }
        fileReader.close();
    }

    public void fileInputStream() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("./API/src/io/FileInput.java");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        byte[] buffer = new byte[1024];
        int read = 0;
        while ((read = fileInputStream.read(buffer)) != -1) {
            System.out.print(new String(buffer, 0, read));
        }
        fileInputStream.close();

    }
}
