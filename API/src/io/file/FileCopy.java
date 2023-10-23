package io.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) throws IOException {
        FileCopy fc = new FileCopy();
        File files = new File("E:\\Documents"); 
        fc.copy(files);
    }

    public boolean copy(File sourceFile) throws IOException {
        if (sourceFile.isFile()) {
            String sourceAbsolutePath = sourceFile.getAbsolutePath();
            String target = "D" + sourceAbsolutePath.substring(1);
            File parentFolder = new File(target).getParentFile();

            if (parentFolder.exists()) {
                FileInputStream fileInputStream = new FileInputStream(sourceAbsolutePath);
                FileOutputStream fileOutputStream = new FileOutputStream(target);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                byte[] bytes = new byte[bufferedInputStream.available()];
                int temp = 0;
                System.out.println("复制 : " + sourceAbsolutePath);
                while ((temp = bufferedInputStream.read(bytes)) != -1) {
                    bufferedOutputStream.write(bytes, 0, temp);
                    bufferedOutputStream.flush();
                }
            } else {
                parentFolder.mkdirs();
            }

        } else {
            File[] folders = sourceFile.listFiles();
            for (File subFile : folders) {
                copy(subFile);
            }
        }
        return false;
    }
}
