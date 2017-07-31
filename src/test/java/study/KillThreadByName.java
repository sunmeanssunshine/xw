package study;

import java.util.Iterator;

/**
 * Created by xuwei on 2017/7/31.
 */
public class KillThreadByName {
    public static void main(String[] args) throws InterruptedException {
        Thread thread_1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + " begin");
                    Thread.sleep(10_1000);
                    System.out.println(Thread.currentThread().getName() + " after 10s");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread_1.setName("thread_1");
        thread_1.start();

        Thread.sleep(100);

        Thread killThread = null;
        Iterator iterator = Thread.getAllStackTraces().keySet().iterator();
        while(iterator.hasNext()){
            Thread t = (Thread)iterator.next();
            if(t.getName().equals("thread_1")){
                killThread = t ;
                break ;
            }
        }
        killThread.stop();
    }
}
