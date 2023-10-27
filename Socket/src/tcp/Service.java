package tcp;

import java.io.*;
import java.util.Scanner;

/**
 * @Author: nekotako
 * @Description: 多线程 公共类
 * @Date: 2023/10/27 11:36 星期五
 */

class SendThread extends Thread {
    private final OutputStream outputStream;

    public SendThread(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public void run() {
        Service service = new Service();
        service.send(outputStream);
    }
}

class ReceiveThread extends Thread {
    private final InputStream inputStream;

    public ReceiveThread(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public void run() {
        Service service = new Service();
        service.receive(inputStream);
    }
}

public class Service {
    // 是否终止标志
    boolean flag;

    /**
     * 发送方法
     *
     * @param outputStream 数据输出流 用于接收键盘输入数据并发送
     */
    public void send(OutputStream outputStream) {
        PrintWriter printWriter = new PrintWriter(outputStream);
        Scanner input = new Scanner(System.in);
        while (true) {
            String msg = input.nextLine();
            printWriter.println(msg);
            printWriter.flush();
        }

    }

    /**
     * @param inputStream 数据输出流 用于从服务端接受数据并输出到控制台
     */
    public void receive(InputStream inputStream) {
        // 转换为字节流
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        // 封装缓冲流
        BufferedReader reader = new BufferedReader(inputStreamReader);
        while (true) {
            try {
                String msg = reader.readLine();
                if (msg != null) {
                    System.out.println("收到消息：" + msg);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
