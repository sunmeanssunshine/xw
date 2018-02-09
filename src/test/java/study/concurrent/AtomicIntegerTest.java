package study.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by xuwei on 2018/2/9.
 */
public class AtomicIntegerTest {

    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
        System.out.println(atomicInteger.get());
        System.out.println(atomicInteger.getAndIncrement());
        System.out.println(atomicInteger.compareAndSet(1, 1));
        System.out.println(atomicInteger.compareAndExchange(1,2));
        System.out.println(atomicInteger.get());
    }
}
