package udp;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Scanner;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 2023/10/28 19:20 星期六
 */

public class Client {
    public static void main(String[] args) throws IOException {
        String msg = null;
        // 创建套接字地址对象
        InetSocketAddress address = new InetSocketAddress("127.0.0.1",1008);
        Scanner input = new Scanner(System.in);
        while (true){
            msg = input.nextLine();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            // 写出到字节数组中
            dataOutputStream.writeUTF(msg);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            // 数据传输 数据包大小限制为64kb
            // 将数据包发送的指定IP主机的指定端口中
            DatagramPacket datagramPacket = new DatagramPacket(byteArray, byteArray.length, address);
            // 发送数据包 把数据包通过当前电脑中指定端口发出
            DatagramSocket datagramSocket = new DatagramSocket(1000);
            datagramSocket.send(datagramPacket);
            datagramSocket.close();
        }
    }
}
