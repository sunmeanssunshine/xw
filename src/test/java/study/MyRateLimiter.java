package study;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by xuw-e on 2018/10/10.
 */
@Log4j
public class MyRateLimiter {
    private final Deque<Long> deque;
    private long timeIntervalInMs;

    public MyRateLimiter(long timeIntervalInMs, int maxLimit) {
        this.timeIntervalInMs = timeIntervalInMs;
        this.deque = new LinkedBlockingDeque<>(maxLimit);
    }

    public boolean incrAndReachLimit() {
        long currentTimeMillis = System.currentTimeMillis();
        boolean success = deque.offerFirst(currentTimeMillis);
        if (success) {
            return false;
        }

        synchronized (this) {
            long last = deque.getLast();
            //还在时间窗口内,超过maxLimit
            if (currentTimeMillis - last < timeIntervalInMs) {
                return true;
            }
            deque.removeLast();
            deque.addFirst(currentTimeMillis);
            return false;
        }
    }


    public static void main(String[] args)  throws InterruptedException {
        MyRateLimiter limiter = new MyRateLimiter(5*1000,3);
        Callable<Void> test = new Callable<Void>(){

            @Override
            public Void call() throws Exception {
                for(int i=0;i<1000;i++){
                    log.info(limiter.incrAndReachLimit());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                return null;
            }
        };
        ExecutorService pool = Executors.newFixedThreadPool(10);
        pool.invokeAll(Arrays.asList(test,test,test,test,test));

        Thread.sleep(100000);
    }
}
