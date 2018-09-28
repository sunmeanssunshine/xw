package thread;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * Created by xuw-e on 2018/9/5.
 */
public class Test {

    public static void unsafeConcurrentUpdate() {
        //final Map<Integer, Integer> map = new HashMap<>();
        final Map<Integer, Integer> map = new ConcurrentHashMap<>();
        //final Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<1000; i++) {
            Thread thread = new Thread() {
                Random random = new Random();
                @Override
                public void run() {
                    for (int i=0; i<1000; i++) {
                        map.put(random.nextInt(), 1);
                    }
                }
            };
            thread.start();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        IntStream.rangeClosed(0, 5).forEach(i -> executorService.submit(() -> System.out.println(Thread.currentThread() + " " + i)));
        unsafeConcurrentUpdate();
    }

    @org.junit.Test
    public void test1() {
        Map<String, String> map = new ConcurrentSkipListMap<>(Collections.reverseOrder());
        map.put("a", "aaa");
        map.put("c", "ccc");
        map.put("b", "bbb");
        map.put("e", "eee");
        System.out.println(map.toString());
    }

    @org.junit.Test
    public void test2() {
        // 1.创建一个实现 Comparator 接口的对象
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object object1, Object object2) {
                if (object1 instanceof NewBookBean && object2 instanceof NewBookBean){
                    NewBookBean newBookBean = (NewBookBean) object1;
                    NewBookBean newBookBean1 = (NewBookBean) object2;
                    //具体比较方法参照 自然排序的 compareTo 方法，这里只举个栗子
                    return newBookBean.getCount() - newBookBean1.getCount();
                }
                return 0;
            }
        };

        //2.将此对象作为形参传递给 TreeSet 的构造器中
        TreeSet treeSet = new TreeSet(comparator);

        //3.向 TreeSet 中添加 步骤 1 中 compare 方法中设计的类的对象
        treeSet.add(new NewBookBean("A",34));
        treeSet.add(new NewBookBean("S",1));
        treeSet.add( new NewBookBean("V",46));
        treeSet.add( new NewBookBean("Q",26));

        treeSet.stream().forEach(System.out::println);
    }

    @org.junit.Test
    public void test3() {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(3);
        integers.add(5);
        for (Integer integer : integers) {
            if (integer<3) {
                integers.remove(integer);
            }
        }
        /**
         * java.util.ConcurrentModificationException
         * 	at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:909)
         * 	at java.util.ArrayList$Itr.next(ArrayList.java:859)
         * 	at thread.Test.test3(Test.java:80)
         */

    }

    @org.junit.Test
    public void stack() {
        Deque<String> stack = new LinkedList<>();
        stack.push("1");
        stack.push("2");
        stack.push("4");
        while (stack.peek() != null) {
            System.out.println(stack.pop());
        }
    }

    @org.junit.Test
    public void arrayDeque() {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>(20);
        arrayDeque.push(1);
        arrayDeque.push(50);
        arrayDeque.push(99);
        while (arrayDeque.peek() != null) {
            System.out.println(arrayDeque.pop());
        }
    }

    @org.junit.Test
    public void sort() {
        String[] arr = {"rr", "e", "4", "t", "0"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @org.junit.Test
    public void arrayList() {
        List<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");
        System.out.println(strings.contains("3"));
    }
}
