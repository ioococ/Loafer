package serialize;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class Serialize {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("./resources/serialized");
        ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
        
        User zs = new User("张三", 18, "上海市", 13919248748L);
        oos.writeObject(zs);
        System.out.println("序列化完成");
    }
}
