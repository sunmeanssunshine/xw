package study.concurrent;

import org.junit.Before;
import org.junit.Test;

import javax.annotation.concurrent.NotThreadSafe;
import javax.annotation.concurrent.ThreadSafe;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

/**
 * Created by xuwei on 2018/1/10.
 */
@NotThreadSafe
public class IdGenerator {
    private final ExecutorService executorService = Executors.newFixedThreadPool(2);

    private final AtomicLong sequenceNumber = new AtomicLong(0L);

    public long getNext() {
        return sequenceNumber.getAndIncrement();
    }

    public void print(long id) {
        System.out.println(Thread.currentThread().getName() + ":" + id);
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

    @Before
    public void init() {

    }

    @Test
    public void test1() {
        IdGenerator idGenerator = new IdGenerator();
        IntStream.range(1, 100).forEach(i -> executorService.submit(() -> idGenerator.print(idGenerator.getNext())));
    }
}
