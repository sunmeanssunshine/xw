package leetcode;

import java.util.*;

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

        TreeSet<Integer> treeSet = new TreeSet<>(Collections.reverseOrder());
        treeSet.add(1);
        treeSet.add(5);
        treeSet.add(3);
        treeSet.add(0);
        treeSet.add(9);
        System.out.println(treeSet);

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(5, 5);
        treeMap.put(6, 6);
        treeMap.put(111,111);
        treeMap.put(11,11);
        treeMap.put(1,1);
        System.out.println(treeMap);

        System.out.println(reverse(646324351));

    }

    public static int reverse(int x) {
        int flag = x < 0 ? -1 : 1;
        Stack<Integer> stack = new Stack<>();
        x = x*flag;
        int count = 0;
        while (x / 10 != 0) {
            stack.push(x%10);
            x = x / 10;
            ++count;
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result = result + stack.peek() * (int)Math.pow(10, count--);

        }
        return result*flag;
    }
}
