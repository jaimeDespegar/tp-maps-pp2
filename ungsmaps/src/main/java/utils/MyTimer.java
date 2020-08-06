package utils;

import java.util.Date;
import java.util.TimerTask;

public class MyTimer extends TimerTask {

    @Override
    public void run() {
        System.out.println("Hago el chequeo para ver a que estado cambio: " + new Date());
    }

    public static void main(String args[]){
        ManagerTimer manager = new ManagerTimer(new MyTimer());
        manager.start();
    }

}