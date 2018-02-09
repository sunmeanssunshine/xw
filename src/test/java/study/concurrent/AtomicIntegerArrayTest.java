package study.concurrent;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * Created by xuwei on 2018/2/9.
 */
public class AtomicIntegerArrayTest {

    static int[] value = new int[] {1,2,3};
    static AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(value);
    public static void main(String[] args) {
        atomicIntegerArray.getAndSet(0, 5);
        System.out.println(atomicIntegerArray.get(0));
        System.out.println(value[0]);
    }
}
