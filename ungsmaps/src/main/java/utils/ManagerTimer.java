package utils;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class ManagerTimer {

    private TimerTask timerTask;

    public ManagerTimer(TimerTask task) {
        this.timerTask = task;
    }

    public void start() {
        Timer myTimer = new Timer(true);
        System.out.println("Empezo el timer: " + new Date());
        myTimer.scheduleAtFixedRate(this.timerTask, 3000, 3000);
        //cancel after sometime
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myTimer.cancel();
        System.out.println("TimerTask cancelled");
    }

}