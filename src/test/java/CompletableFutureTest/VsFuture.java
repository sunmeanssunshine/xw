package CompletableFutureTest;

import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created by xuwei on 2017/7/19.
 */
public class VsFuture {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        Future<String> result = executor.submit(() -> {
            TimeUnit.SECONDS.sleep(3);
            return "hello";
        });
        try {
            System.out.println(result.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        ////////////////////

        CompletableFuture<String> resultCompletableFuture = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                return "hello1";
            }
        }, executor);

        System.out.println(resultCompletableFuture.thenAccept(new Consumer<String>(){
            @Override
            public void accept(String t) {
                System.out.println(t + "---");
                System.out.println(Thread.currentThread().getName() + "---");
            }
        }));
        System.out.println(123);

    }
}
