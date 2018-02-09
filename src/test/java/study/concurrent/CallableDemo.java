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
        Long t1 = System.currentTimeMillis();
        System.out.println("begin: " + t1);
        for (int i=0; i<1000; i++){
            futures.add(exe.submit(() -> {
                Thread.sleep(1_000);//模拟耗时
                return "a";
            }));
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
        System.out.println("end: " + (System.currentTimeMillis()-t1));
        /**
         1500606257117
         a
         a
         a
         a
         a
         1019  最终耗时1s多，说明异步
         *
         */
    }
}
