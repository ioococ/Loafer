package udp;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 2023/10/28 19:12 星期六
 */

public class Server {
    public static void main(String[] args) throws Exception {
        // 创建UDP对象 监听端口
        DatagramSocket socket = new DatagramSocket(1008);

        byte[] bytes = new byte[1024];
        // 包接收器 用于接收数据 把数据读取到字节数组中
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
        // 阻塞式接收
        while (true){
            // 通过监听的端口 持续接收数据
            socket.receive(packet);
            // 把字节数组中的值 取出并转换为流
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            // 转换为数据流
            DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
            System.out.println(dataInputStream.readUTF());
        }
    }
}
