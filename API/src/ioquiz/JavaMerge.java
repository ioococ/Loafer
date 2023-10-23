package ioquiz;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @Author: nekotako
 * @Description: TODO
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
            m.merge(javaFile,new File("./resources/JavaMerge.txt"));
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
