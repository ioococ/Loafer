package serialize;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class UnSerialize {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FileInputStream fileInputStream = new FileInputStream(new File("./resources/serialized"));
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        User user = (User) objectInputStream.readObject();
        System.out.println(user);
        System.out.println(new BufferedInputStream(objectInputStream).available());
    }
}
