package study.queue;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by xuw-e on 2018/10/10.
 */
public class QueueDemo {

    @Test
    public void priorityQueue() {
        Queue<Integer> pq = new PriorityQueue<>();
        pq.offer(2);
        pq.offer(3);
        pq.addAll(Arrays.asList(4,5,9,6,11,98,764,66,34,56,989));
        while (pq.peek() != null) {
            System.out.println(pq.poll() + " ");
        }
    }
}
