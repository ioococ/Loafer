package ioquiz;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @Author: nekotako
 * @Description: 给定一个项目,把该项目中所有的java文件中的代码,都保存到D盘下test.txt文件中
 * @Date: 2023/10/23 19:52 星期一
 */

public class JavaMerge {

    static ArrayList<File> javaFiles = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        File Root = new File("./");
        Merge m = new Merge();
        JavaMerge.getJavaFiles(Root);
        System.out.println(javaFiles);
        for (File javaFile : javaFiles) {
            m.merge(javaFile,new File("./test.txt"));
//            m.merge(javaFile,new File("./resources/JavaMerged.txt"));
        }
    }
    public static void getJavaFiles(File folder){
        if (folder.isFile()){
            File files = folder;
            if (files.getName().endsWith(".java")){
                javaFiles.add(files);
                System.out.println(files);
            }
        } else {
            File[] subFiles = folder.listFiles();
            for (File subFile : subFiles) {
                getJavaFiles(subFile);
            }
        }
    }
}
