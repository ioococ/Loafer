package demo;

public class SingletonTest {
    public static void main(String[] args) {
        new SingletonThread().start();
        new SingletonThread().start();
        new SingletonThread().start();
        new SingletonThread().start();
        new SingletonThread().start();
        new SingletonThread().start();
        new SingletonThread().start();
        new SingletonThread().start();
    }
}

class SingletonThread extends Thread {
    @Override
    public void run() {
        System.out.println(MySingleton.getInstance());
    }
}

class MySingleton {
    private volatile static MySingleton instance;

    private MySingleton() {}

    public static MySingleton getInstance() {
        synchronized (MySingleton.class) {
            if (instance == null) {
                instance = new MySingleton();
            }
        }
        return instance;
    }

}
