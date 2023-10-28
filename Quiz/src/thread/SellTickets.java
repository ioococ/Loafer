package thread;

/**
 * @Author: nekotako
 * @Description: 三个售票窗口同时售票, 并且票不能重复
 * @Date: 2023/10/28 10:06 星期六
 */

public class SellTickets {

    public static void main(String[] args) throws InterruptedException {
        Tickets tickets = new Tickets();
        long startTime = System.currentTimeMillis();

        Thread thread1 = new Thread(tickets, "窗口1");
        Thread thread2 = new Thread(tickets, "窗口2");
        Thread thread3 = new Thread(tickets, "窗口3");

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}

class Tickets implements Runnable {

    static int countTickets = 100;

    @Override
    public void run() {
        sellTickets();
    }

    public void sellTickets() {
        synchronized (this) {
            while (countTickets > 0) {
                try {
                    System.out.println(Thread.currentThread().getName() + "卖出了" + countTickets);
                    countTickets--;
                    this.wait(10);
                } catch (Exception e) {
                }
            }
        }
    }
}
