

package com.example.lib;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.util.regex.Matcher;

import org.apache.commons.codec.digest.DigestUtils;

public class LibApplication {
    public LibApplication() {
    }

    public static void main(String[] args) throws Exception {
        String jarPath = LibApplication.class.getProtectionDomain().getCodeSource().getLocation().getFile();
        jarPath = URLDecoder.decode(jarPath, "UTF-8");
        jarPath = (new File(jarPath)).getParent();
        File originalFile = new File(jarPath + File.separator + "SEUS PTGI HRR Test 2.1.zip");
        String baseFolderName = jarPath + File.separator + "SEUS PTGI HRR Test 2.1 GFME v1.9";
        File baseFolder = new File(baseFolderName);
        baseFolder.mkdirs();
        ClassLoader classLoader = LibApplication.class.getClassLoader();
        BufferedReader folderListReader = new BufferedReader(new InputStreamReader(classLoader.getResourceAsStream("folders")));

        String folderName;
        while ((folderName = folderListReader.readLine()) != null) {
            folderName = folderName.replaceAll("#", Matcher.quoteReplacement(File.separator));
            (new File(baseFolderName + File.separator + folderName)).mkdirs();
        }

        BufferedReader contentListReader = new BufferedReader(new InputStreamReader(classLoader.getResourceAsStream("contents")));

        String fileName;
        while ((fileName = contentListReader.readLine()) != null) {
            String originalFileName = fileName;
            fileName = fileName.replaceAll("#", Matcher.quoteReplacement(File.separator));
            File target = new File(baseFolderName + File.separator + fileName);
            target.createNewFile();
            BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(target));
            String md5Hex = DigestUtils.md5Hex(originalFileName.replaceAll("#", "\\\\"));
            BufferedInputStream reader = new BufferedInputStream(classLoader.getResourceAsStream(md5Hex));
            byte[] content = new byte[8192];

            int arrLength;
            while ((arrLength = reader.read(content)) > -1) {
                writer.write(content, 0, arrLength);
            }

            writer.close();
            reader.close();
        }

        System.out.println("Export success.");
    }
}
