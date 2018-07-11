package CompletableFutureTest;

import org.junit.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by xuwei on 2018/2/26.
 */
public class CompletableTestDemo {

    /**
     * 进行变换
     */
    @Test
    public void thenApply() {
        String result = CompletableFuture
                .supplyAsync(() -> " hello")
                .thenApplyAsync(s -> s + " world")
                .thenApply(s -> s + " end")
                .join();
        System.out.println(result);
    }

    /**
     * 进行消耗
     */
    @Test
    public void thenAccept() {
        CompletableFuture.supplyAsync(() -> "hello").thenAccept(s -> System.out.println(s + " world"));
    }

    /**
     * 对上一步的计算结果不关心，执行下一个操作。
     */
    @Test
    public void thenRun() {
        CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        }).thenRun(() -> System.out.println("hello world")).join();
    }

    /**
     * 结合两个CompletionStage的结果，进行转化后返回
     */
    @Test
    public void thenCombine() {
        String result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "world";
        }), (s1, s2) -> s1 + " " + s2).join();
        System.out.println(result);
    }


    /**
     * 结合两个CompletionStage的结果，进行消耗
     */
    @Test
    public void thenAcceptBoth() {
        CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        }).thenAcceptBoth(CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "world";
        }), (s1, s2) -> System.out.println(s1 + " " + s2)).join();

    }


    /**
     * 在两个CompletionStage都运行完执行。
     */
    @Test
    public void runAfterBoth(){
        CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "s1";
        }).runAfterBothAsync(CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "s2";
        }), () -> System.out.println("hello world")).join();
    }


    /**
     * 两个CompletionStage，谁计算的快，我就用那个CompletionStage的结果进行下一步的转化操作。
     */
    @Test
    public void applyToEither() {
        String result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "s1";
        }).applyToEither(CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello world";
        }), s -> s).join();
        System.out.println(result);
    }

    /**
     * 两个CompletionStage，任何一个完成了都会执行下一步的操作（Runnable）。
     */
    @Test
    public void runAfterEither() {
        CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "s1";
        }).runAfterEither(CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "s2";
        }), () -> System.out.println("hello world")).join();
    }


    /**
     * 当运行时出现了异常，可以通过exceptionally进行补偿。
     */
    @Test
    public void exceptionally() {
        String result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (1 == 1) {
                throw new RuntimeException("测试一下异常情况");
            }
            return "s1";
        }).exceptionally(e -> {
            System.out.println(e.getMessage());
            return "hello world";
        }).join();
        System.out.println(result);
    }


    /**
     * 当运行完成时，对结果的记录。这里的完成时有两种情况，一种是正常执行，返回值。
     * 另外一种是遇到异常抛出造成程序的中断。
     * 这里为什么要说成记录，因为这几个方法都会返回CompletableFuture，
     * 当Action执行完毕后它的结果返回原始的CompletableFuture的计算结果或者返回异常。所以不会对结果产生任何的作用。
     */
    @Test
    public void whenComplete() {
        String result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (1 == 1) {
                throw new RuntimeException("测试一下异常情况");
            }
            return "s1";
        }).whenComplete((s, t) -> {
            System.out.println(s);
            System.out.println(t.getMessage());
        }).exceptionally(e -> {
            System.out.println(e.getMessage());
            return "hello world";
        }).join();
        System.out.println(result);

    }


    /**
     * 运行完成时，对结果的处理。
     * 这里的完成时有两种情况，一种是正常执行，返回值。
     * 另外一种是遇到异常抛出造成程序的中断。
     */
    @Test
    public void handle() {
        String result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //出现异常
            if (1 == 1) {
                throw new RuntimeException("测试一下异常情况");
            }
            return "s1";
        }).handle((s, t) -> {
            if (t != null) {
                return "hello world";
            }
            return s;
        }).join();
        System.out.println(result);
    }



    @Test
    public void thenCompose() {
        CompletableFuture
                .supplyAsync(() -> "hello")
                .thenCompose(s -> CompletableFuture.supplyAsync(()->s + "world"))
                .thenApplyAsync(s->s+"...")
                .thenAccept(System.out::println)
                .join();
    }

    @Test
    public void acceptEither() {
        CompletableFuture
                .supplyAsync(() -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return "hello";})
                .acceptEitherAsync(CompletableFuture.supplyAsync(() -> "world"), System.out::print);
    }


    @Test
    public void allOf() {
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> "s1");
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> "s2");
        CompletableFuture<String> f3 = CompletableFuture.supplyAsync(() -> "s3");
        CompletableFuture
                .allOf(f1,f2,f3)
                .thenApply(v -> Stream.of(f1,f2,f3).map(CompletableFuture::join).collect(Collectors.joining("-")))
                .thenAccept(System.out::println);
    }


    @Test
    public void anyOf() {
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> "s1");
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> "s2");
        CompletableFuture<String> f3 = CompletableFuture.supplyAsync(() -> "s3");
        CompletableFuture
                .anyOf(f1,f2,f3)
                .thenApply(v -> Stream.of(f1,f2,f3).map(CompletableFuture::join).collect(Collectors.joining("-")))
                .thenAccept(System.out::println);
    }

    @Test
    public void test() {
        float a = 5f / 6f;
        System.out.println(5f / 6f);
        System.out.println("".isEmpty());

        System.out.println(LocalDate.now().minusDays(1L));
        System.out.println(LocalDate.now().atStartOfDay().minusDays(1L));

        TreeMap<String, String> tmap = new TreeMap<>();
        tmap.put("4", "政治");
        tmap.put("5", "历史");
        tmap.put("6", "地理");
        tmap.put("7", "生物");
        tmap.put("8", "化学");
        tmap.put("1", "语文");
        tmap.put("3", "英语");
        tmap.put("2", "数学");
        System.out.println(tmap);

    }

    @Test
    public void test7() {
    }

}
