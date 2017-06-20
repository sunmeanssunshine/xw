package study.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by xuwei on 2017/6/15.
 */
public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService exe = Executors.newCachedThreadPool();
        List<Future<String>> futures = new ArrayList<>();
        for (int i=0; i<5; i++){
            futures.add(exe.submit(() -> "a"));
        }
        for (Future<String> fs : futures){
            try {
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
