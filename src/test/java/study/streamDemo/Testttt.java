package study.streamDemo;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by xuwei on 2017/6/30.
 */
public class Testttt {
    public static void main(String[] args) {
        String s = "following_version_id\n" +
                "ed5ab1ee9c6846dea627669f7d5a730d\n" +
                "0328a1c20c804a9caaeebf1ff920509b\n" +
                "73ed3be90e2c42e9944b0711767d692c\n" +
                "0328a1c20c804a9caaeebf1ff920509b\n" +
                "070e0289707b4866a41ec099c73f48b7\n" +
                "33875485e157444792db61217b34e874\n" +
                "070e0289707b4866a41ec099c73f48b7\n" +
                "26711304f4f844bda222b6e6b5b9dab5\n" +
                "c2fe6a5cb3e7443590f99b0ada5642e5\n" +
                "c3aa773426854367972860f5d43bfc79\n" +
                "c3aa773426854367972860f5d43bfc79\n" +
                "70c804e6a2fa4441a6f2e28316a5006c\n" +
                "c3aa773426854367972860f5d43bfc79\n" +
                "c3aa773426854367972860f5d43bfc79\n" +
                "c3aa773426854367972860f5d43bfc79\n" +
                "c2fe6a5cb3e7443590f99b0ada5642e5\n" +
                "c3aa773426854367972860f5d43bfc79\n" +
                "c3aa773426854367972860f5d43bfc79\n" +
                "26711304f4f844bda222b6e6b5b9dab5\n" +
                "c3aa773426854367972860f5d43bfc79\n" +
                "5b9d9febe3ed42f9ad008788481e7969\n" +
                "1794226de71e4856ac696b5a56ea3cf9\n" +
                "1794226de71e4856ac696b5a56ea3cf9\n" +
                "3861ccae466148a3b8f519249c660044\n" +
                "3861ccae466148a3b8f519249c660044\n" +
                "d1b44789e12c4ff6b82dd599b4d49d0f\n" +
                "d1b44789e12c4ff6b82dd599b4d49d0f\n" +
                "7339c0bff7494c91b436a2ce2bf8be8a\n" +
                "7339c0bff7494c91b436a2ce2bf8be8a";
        String result = Stream.of(s.split("\n")).distinct().collect(Collectors.joining("','"));
        System.out.println(result);
        //ConcurrentMap

        String ss = "1126328225514272.346523";
        System.out.println(ss.split("\\.")[0]);

    }

    @Test
    public void test1(){
        Stream.of("d2", "a2", "b1", "b3", "c")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("A");
                })
                .forEach(s -> System.out.println("forEach: " + s));
    }

    @Test
    public void test2() {
        List<Person> persons =
                Arrays.asList(
                        new Person("Max", 18),
                        new Person("Peter", 23),
                        new Person("Pamela", 23),
                        new Person("David", 12));
        Collector<Person, StringJoiner, String> personNameCollector =
                Collector.of(
                        () -> new StringJoiner(" | "),  // supplier
                        (j, p) -> j.add(p.name.toUpperCase()),  // accumulator
                        (j1, j2) -> j1.merge(j2),               // combiner
                        StringJoiner::toString);                // finisher
        String names = persons
                .stream()
                .collect(personNameCollector);

        System.out.println(names);

        Integer ageSum = persons
                .stream()
                .reduce(0,
                        (sum, p) -> {
                            System.out.format("accumulator: sum=%s; person=%s\n", sum, p);
                            return sum += p.age;
                        },
                        (sum1, sum2) -> {
                            System.out.format("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
                            return sum1 + sum2;
                        });

    }

    @Test
    public void test3() {
        StringJoiner sj = new StringJoiner(":", "[", "]");
        sj.add("George").add("Sally").add("Fred");
        System.out.println(sj.toString());
    }

    @Test
    public void test4() {
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        System.out.println(commonPool.getParallelism());    // 3
    }

    @Test
    public void test5() {
        Arrays.asList("a1", "a2", "b1", "c2", "c1")
                .parallelStream()
                .filter(s -> {
                    System.out.format("filter: %s [%s]\n",
                            s, Thread.currentThread().getName());
                    return true;
                })
                .map(s -> {
                    System.out.format("map: %s [%s]\n",
                            s, Thread.currentThread().getName());
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.format("forEach: %s [%s]\n",
                        s, Thread.currentThread().getName()));
    }
}
