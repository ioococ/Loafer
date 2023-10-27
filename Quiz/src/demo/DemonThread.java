package demo;

public class DemonThread {
    public static void main(String[] args) throws InterruptedException {
        Thread d = new Thread(new MyDemonThread());
        d.setDaemon(true);
        d.start();
        for (int i = 0; i < 6; i++) {
            Thread.sleep(500);
            System.out.println("主线程运行中");
        }
    }
}

class MyDemonThread implements Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread().getName() + "守护线程运行中");
        }
    }

}
