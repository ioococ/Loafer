package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AddData {

    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(MyThread.list);

    }
}

class MyThread extends Thread {
    public static List<Integer> list = new ArrayList<>();

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            add();
        }
    }

    public void add() {
        Random random = new Random();
        synchronized (this) {
            int nextInt = random.nextInt();
            list.add(nextInt);
            System.out.println(getName() + "添加了" + nextInt);
        }
    }
}