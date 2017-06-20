package study.concurrent;

import java.util.concurrent.BlockingQueue;

/**
 * Created by xuwei on 2017/6/15.
 */
public class Producer implements Runnable {
    protected BlockingQueue queue = null;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            queue.add("1");
            //Thread.sleep(1000);
            queue.offer("2");
            Thread.sleep(1000);
            queue.put("3");
            //Thread.sleep(1000);
            queue.put("4");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
