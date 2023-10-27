package tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author: nekotako
 * @Description: 多线程的消息B端
 * @Date: 2023/10/27 11:37 星期五
 */

public class Client {

    static Socket init() {
        try {
            // 创建一个客户端对象并返回
//            return new Socket("192.168.1.18",10002);
            return new Socket("127.0.0.1", 1008);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        Socket socket = init();
        // 向服务端发送数据
        OutputStream outputStream = socket.getOutputStream();
        // 从服务端接受数据
        InputStream inputStream = socket.getInputStream();
        new SendThread(outputStream).start();
        new ReceiveThread(inputStream).start();
    }
}
