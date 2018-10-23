package leetcode;

import java.util.Arrays;
import java.util.Collection;
import java.util.PriorityQueue;

/**
 * Created by xuw-e on 2018/10/23.
 */
public class TopK<E> {
    private PriorityQueue<E> p;
    private int k;
    public TopK(int k) {
        this.k = k;
        this.p = new PriorityQueue<>(k);
    }
    public void addAll(Collection<? extends E> c) {
        for (E e : c) {
            this.add(e);
        }

    }

    public void add(E e) {
        if (p.size()<k) {
            p.add(e);
            return;
        }
        Comparable<? super E> head = (Comparable<? super E>) p.peek();
        if (head.compareTo(e) > 0) {
            return;
        }
        p.poll();
        p.add(e);
    }

    public <T> T[] toArray(T[] a) {
        return p.toArray(a);
    }

    public E getKth() {
        return p.peek();
    }

    public static void main(String[] args) {
        TopK<Integer> top3 = new TopK<>(3);
        top3.addAll(Arrays.asList(1,99,33,77,999,324,121231,3415145,4545,993,2,4,6,2));
        System.out.println(Arrays.toString(top3.toArray(new Integer[0])));
        System.out.println(top3.getKth());
    }
}
