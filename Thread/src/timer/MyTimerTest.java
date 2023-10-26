package timer;

import java.util.Timer;
import java.util.TimerTask;

public class MyTimerTest {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new MyTimer(), 500);
    }
}

class MyTimer extends TimerTask {

    @Override
    public void run() {
        System.out.println("run()方法执行");
    }
}
