package study.concurrent;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by xuwei on 2018/1/10.
 */
public class IdGenerator {
    private final AtomicLong sequenceNumber = new AtomicLong(0L);

    public long getNext() {
        return sequenceNumber.getAndIncrement();
    }

    public static void main(String[] args) {
        IdGenerator idGenerator = new IdGenerator();
        Thread thread1 = new Thread(() -> System.out.println(Thread.currentThread().getName() + ":" + idGenerator.getNext()));
        Thread thread2 = new Thread(() -> System.out.println(Thread.currentThread().getName() + ":" + idGenerator.getNext()));
        Thread thread3 = new Thread(() -> System.out.println(Thread.currentThread().getName() + ":" + idGenerator.getNext()));
        Thread thread4 = new Thread(() -> System.out.println(Thread.currentThread().getName() + ":" + idGenerator.getNext()));
        Thread thread5 = new Thread(() -> System.out.println(Thread.currentThread().getName() + ":" + idGenerator.getNext()));
        Thread thread6 = new Thread(() -> System.out.println(Thread.currentThread().getName() + ":" + idGenerator.getNext()));
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        System.out.println(Thread.currentThread().getName() + ":" + idGenerator.getNext());
    }
}
