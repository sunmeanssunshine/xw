package study.concurrent;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xuwei on 2018/1/10.
 */
public class AddThread implements Runnable {
    private List<Double> list;

    public AddThread(List<Double> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10000; ++i) {
            list.add(Math.random());
        }
    }


    public static void main(String[] args) {
        /**
         * List<Double> list = new CopyOnWriteArrayList<>();
         * 不报错
         */
        /**
         * Exception in thread "pool-1-thread-2" java.lang.ArrayIndexOutOfBoundsException: 3717
         * 有可能报错
         */
        List<Double> list = new ArrayList<>();
        ExecutorService es = Executors.newFixedThreadPool(2);
        es.execute(new AddThread(list));
        es.execute(new AddThread(list));
        es.shutdown();
    }
}
