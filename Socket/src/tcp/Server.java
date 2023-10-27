package tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: nekotako
 * @Description: 多线程的消息A端
 * @Date: 2023/10/27 11:37 星期五
 */

public class Server {
    public static ServerSocket init() {
        try {
            return new ServerSocket(1008);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = init();
        System.out.println("等待客户端连接中");
        // 等待连接  只要有客户端连接 则返回一个客户端对象
        Socket socket = serverSocket.accept();
        System.out.println("客户端连接成功");
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        new ReceiveThread(inputStream).start();
        new SendThread(outputStream).start();
    }

}
