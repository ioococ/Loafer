package deathlock;

public class DeathLock {
    public static void main(String[] args) {
        Object fo1 = new Object();
        Object fo2 = new Object();
        Thread t1 = new Thread1(fo1, fo2);
        Thread t2 = new Thread2(fo1, fo2);
        t1.start();
        t2.start();

    }
}

class Thread1 extends Thread {
    Object o1;
    Object o2;

    public Thread1(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    @Override
    public void run() {
        synchronized (o1) {
            System.out.println(Thread.currentThread().getName() + " 已锁定o1");
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName() + " 已锁定o2");
            }

        }
    }
}

class Thread2 extends Thread {
    Object o1;
    Object o2;

    public Thread2(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    @Override
    public void run() {
        synchronized (o2) {
            System.out.println(Thread.currentThread().getName() + " 已锁定o2");
            synchronized (o1) {
                System.out.println(Thread.currentThread().getName() + " 已锁定o1");
            }

        }
    }
}