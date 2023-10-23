package io.file;

import java.io.File;

public class FileMethod {
    public static void main(String[] args) {
        File file = new File("null");
        file.delete();
        file.getName();
        file.getParent();
        file.exists();
    }
}
