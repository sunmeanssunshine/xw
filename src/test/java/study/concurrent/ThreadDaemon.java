package study.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * Created by xuwei on 2017/6/16.
 */
public class ThreadDaemon implements Runnable {
    public static void main(String[] args) throws InterruptedException {
        for (int i=0; i<5; i++){
            Thread daemon = new Thread(new ThreadDaemon());
            daemon.setDaemon(true);
            daemon.start();
        }
        System.out.println("all daemon started");
        //TimeUnit.MICROSECONDS.sleep(200);
        Thread.sleep(300);
    }


    @Override
    public void run() {
            try {
                while (true) {
                    Thread.sleep(100);
                    //TimeUnit.MICROSECONDS.sleep(10000);
                    System.out.println(Thread.currentThread() + " " + this);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}
