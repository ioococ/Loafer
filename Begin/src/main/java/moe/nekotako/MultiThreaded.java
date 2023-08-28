package moe.nekotako;

/**
 * @Author: nekotako
 * @Date: 2023/8/28 16:26
 */
public class MultiThreaded {
    public static void main(String[] args) {
        GoGoGo go = new GoGoGo();
        go.start();
        GoGoGo go2 = new GoGoGo();
        go2.start();
    }
}

class GoGoGo extends Thread {
    private Thread thread;

    @Override
    public void run() {
        System.out.println("线程，启动！！！");
        BuyClothes fastBuying = new BuyClothes();
        fastBuying.singleThread();
    }

    @Override
    public void start() {
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }
}
