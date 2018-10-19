package study.queue;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.common.collect.Lists;
import model.Child;
import org.junit.Test;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;
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

    @Test
    public void test() {
        List<Child> children = Lists.newArrayList();
        if (!CollectionUtils.isEmpty(children)) {
            System.out.println("dd");
        }
    }

    @Test
    public void test1() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }
}
