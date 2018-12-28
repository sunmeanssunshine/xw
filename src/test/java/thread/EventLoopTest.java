package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by xuw-e on 2018/12/24.
 */
public class EventLoopTest {
    public static void main(String[] args) {
        AtomicInteger counter = new AtomicInteger();

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            counter.set(1);
            System.out.println(counter);
        });
        executor.submit(() -> {
            counter.compareAndSet(1, 2);
            System.out.println(counter);
        });
        executor.submit(() -> {
            counter.set(3);
            System.out.println(counter);
        });
        executor.submit(() -> {
            counter.compareAndSet(2, 2);
            System.out.println(counter);
        });
    }
}
