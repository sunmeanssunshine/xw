package study.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by xuwei on 2017/6/15.
 */
public class BlockingQueueExample {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue queue = new ArrayBlockingQueue(20);

        Producer producer = new Producer(queue);
        Producer producer1 = new Producer(queue);
        Producer producer2 = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        new Thread(producer).start();
        new Thread(producer1).start();
        new Thread(producer2).start();
        new Thread(consumer).start();

        //Thread.sleep(4000);
    }
}
