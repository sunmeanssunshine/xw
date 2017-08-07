package CompletableFutureTest;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Created by xuwei on 2017/7/26.
 */
public class CFTest {

    public static void main(String args[]) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture
                .supplyAsync(() -> cale(50))
                .thenCompose(i -> CompletableFuture.supplyAsync(() -> cale(i)))
                .thenCompose(i -> CompletableFuture.supplyAsync(() -> cale2(i)))
                .exceptionally(ex -> {
                    System.out.println("ex.toString() = " + ex.toString());
                    return 0;
                })
                .thenApply(i -> Integer.toString(i))
                .thenApply(str -> "result is" + "\"" + str + "\"")
                .thenAccept(msg -> System.out.println(Thread.currentThread().getName() + ": " + msg));
        System.out.println("-----------");
        future.get();

    }

    @Test
    public void test() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture
                .supplyAsync(() -> cale(50))
                .thenCompose(i -> CompletableFuture.supplyAsync(() -> cale(i)))
                .thenCompose(i -> CompletableFuture.supplyAsync(() -> cale2(i)))
                .exceptionally(ex -> {
                    System.out.println("ex.toString() = " + ex.toString());
                    return 0;
                })
                .thenApply(i -> Integer.toString(i))
                .thenApply(str -> "\"" + str + "\"")
                .thenAccept(msg -> System.out.println(Thread.currentThread().getName() + ": " + msg));
        System.out.println("-----------");
        future.get();
    }

    public static Integer cale(Integer para) {
        try {
            Thread.sleep(1_000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return para * para;
    }
    public static Integer cale2(Integer para) {
        try {
            Thread.sleep(2_000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return para + para;
    }

}
