package study.streamDemo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

/**
 * Created by xuwei on 2017/8/2.
 */
public class StreamTest {
    @Test
    public void test(){
        IntStream.range(1, 100).parallel()
                .filter(e -> {
                    if (e > 5) {
                        System.out.println(e);
                        return true;
                    }else {
                        return false;
                    }
                }).findAny().ifPresent(e-> System.out.println("result: " + e));
    }

    @Test
    public void test1() {
        List<String> l = new ArrayList(Arrays.asList("one", "two"));
        Stream<String> sl = l.stream();
        l.add("three");
        String s = sl.collect(joining(" "));
        System.out.println(s);
        /**
         * one two three
         * Laziness-seeking
         */
    }

    public static void main(String[] args) {
        List<Integer> num1 = Arrays.asList(1,9,10,5,2);
        List<Integer> num2 = Arrays.asList(3,4);
        List<int []> result = num1.stream()
                .flatMap(i -> num2.stream().map(j -> new int[]{i,j}))
                .collect(Collectors.toList());
        result.stream().forEach(System.out::println);
        System.out.println("---");
        List<int []> result1 = new ArrayList<>();
        for (Integer i : num1){
            for (Integer j : num2){
                int [] tmp = new int[]{i,j};
                result1.add(tmp);
            }
        }
        System.out.println("------");

        int sum = num1.stream().reduce((a, b) -> a * b).orElse(11111);
        System.out.println("sum: " + sum);
        System.out.println("+++++++++");
        num1.stream().forEachOrdered(System.out::println);

        Stream.generate(Math::random).limit(5).forEach(System.out::println);

    }
}
