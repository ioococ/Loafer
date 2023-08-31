package moe.work.smartphone;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 2023/8/31 19:21 星期四
 */

public class SubHandset {
}

class CommonHandset extends Handset implements PlayWiring {

    @Override
    public void play(String name) {
        System.out.println("开始播放" + name);
    }

    @Override
    public void sendInfo() {
        System.out.println("发送文字信息");
    }

    @Override
    public void call() {
        System.out.println("开始语音通话");
    }

    @Override
    public void info() {
        super.info();
    }

    public CommonHandset(String brand, String name) {
        setBrand(brand);
        info();
        play(name);
        sendInfo();
        call();
    }
}

class AptitudeHandset extends Handset implements Network, PlayWiring, TheakePictures {
    @Override
    public void networkConn() {
        System.out.println("已经启动移动网络");
    }

    @Override
    public void play(String name) {
        System.out.println("开始播放" + name);
    }

    @Override
    public void takePictures() {
        System.out.println("咔嚓......拍照成功");
    }

    @Override
    public void sendInfo() {
        System.out.println("发送带图片与文字的信息");
    }

    @Override
    public void call() {
        System.out.println("开始视频通话");
    }

    @Override
    public void info() {
        super.info();
    }

    public AptitudeHandset(String brand, String name) {
        setBrand(brand);
        info();
        networkConn();
        play(name);
        takePictures();
        sendInfo();
        call();
    }
}
