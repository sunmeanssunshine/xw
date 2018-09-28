package rxjava2;

import lombok.extern.log4j.Log4j;
import okhttp3.Call;
import org.junit.Test;
import rx.Observable;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by xuwei on 2018/2/26.
 */
@Log4j
public class Demo2 {


    @Test
    public void logTest() {
        log.error("ddddddddddddd");
    }

    @Test
    public void test() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Integer> future = executorService.submit(() -> {Thread.sleep(2000L); return 1;});
        Future<Integer> future1 = executorService.submit(() -> {Thread.sleep(3000L); return 2;});
        Future<Integer> future2 = executorService.submit(() -> {Thread.sleep(4000L); return 3;});
        Future<Integer> future3 = executorService.submit(() -> {Thread.sleep(5000L); return 4;});
        long t = System.currentTimeMillis();
        Observable.just(future.get(), future1.get())
                .mergeWith(Observable.just(future2.get(), future3.get()))
                .toList()
                .subscribe(item -> System.out.println(item));
        System.out.println(System.currentTimeMillis() - t);
        /**
         * [1, 2, 3, 4]
         * 5026
         */
    }

}
