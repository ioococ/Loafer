package demon;

public class DemonTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyDemon());
        thread.setDaemon(true);
        thread.start();
        for (int i = 0; i < 6; i++) {
            System.out.println("main: "+i);
            Thread.sleep(1000);
        }
    }
}

/**
 * MyDemon
 */
class MyDemon implements Runnable {
    @Override
    public void run() {
        Thread inner = new Thread(new MyInnerDemon());
        inner.setDaemon(true);
        inner.start();
        int i = 0;
        while (true) {
            System.out.println("OuterDemon: " + i++);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
    }
}

class MyInnerDemon implements Runnable {
    @Override
    public void run() {
        int i = 0;
        while (true) {
            System.out.print("InnerDemon: " + i++);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
            }
        }
    }
}