package study.concurrent.Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xuwei on 2017/6/20.
 */
public class VolatileTest {
    public volatile int inc = 0;
    //public Lock lock = new ReentrantLock();
    public synchronized void  increase() {

        //lock.lock();
        inc++;
        //lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        final VolatileTest test = new VolatileTest();
        for(int i=0;i<10;i++){
            new Thread(() -> {
                for(int j=0;j<10000;j++)
                    test.increase();
            }).start();
        }

        System.out.println("----");
        //while(Thread.activeCount()>1)  //保证前面的线程都执行完
         //   Thread.yield();
        Thread.sleep(10000);

        System.out.println("-----");
        System.out.println(test.inc);
    }
}
