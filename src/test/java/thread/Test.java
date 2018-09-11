package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * Created by xuw-e on 2018/9/5.
 */
public class Test {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        IntStream.rangeClosed(0, 5).forEach(i -> executorService.submit(() -> System.out.println(Thread.currentThread() + " " + i)));
    }
}
