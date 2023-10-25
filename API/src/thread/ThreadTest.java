package thread;

public class ThreadTest {
    public static void main(String[] args) {
        CreateThreadByExtends createThreadByExtends = new CreateThreadByExtends();
        // Thread createThreadByImplements = new Thread(new createThreadByImplements());
        // createThreadByExtends.getPriority();
        createThreadByExtends.setPriority(1);
        createThreadByExtends.start();
        Thread.currentThread().setPriority(10);
        // createThreadByImplements.start();
        for (int i = 1; i < 6; i++) {
            System.out.println(Thread.currentThread().getName() +"    :"+ i);
        }
    }
}

class CreateThreadByExtends extends Thread {
    @Override
    public void run() {
        for (int i = 1; i < 6; i++) {
            System.out.println(super.getName() +":"+ i);
        }
        // super.run();
    }
}

class CreateThreadByImplements implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i < 11; i++) {
            System.out.println("run" + i);
            
        }
        // super.run();
    }


}
