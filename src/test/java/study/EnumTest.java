package study;

import org.junit.Test;

import java.io.File;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;

/**
 * Created by xuwei on 2017/6/6.
 */
public class EnumTest {
    enum Day {
        MONDAY, TUESDAY, WEDNESDAY,
        THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    public static void main(String[] args) {
        Day[] days = Day.values();
        for (Day day : days) {
            System.out.println(day);
        }


        System.out.println("------------------");

        EnumSet<Day> enumSet = EnumSet.range(Day.MONDAY, Day.WEDNESDAY);
        for (Day day : enumSet) {
            System.out.println(day);
        }

    }

    @Test
    public void test() {
        Set<Integer> set = Collections.singleton(1);
        System.out.println(set);

        List<String> list = new ArrayList<>();
        Collections.addAll(list, "a", "b", "b", "c", "c", "b");
        list.remove("b");
        System.out.println(list);
        list.removeAll(Collections.singleton("c"));
        System.out.println(list);
    }

    @Test
    public void test2() {
        File[] files = new File(".").listFiles();
        Arrays.stream(files).filter(File::isFile).map(File::getName).forEach(System.out::println);
        /**
         * .gitignore
         * 1.jpg
         * 1.txt
         * 3.jpg
         * 5.jpg
         * pom.xml
         * xw.iml
         */
    }

    @Test
    public void test3() throws ExecutionException, InterruptedException {
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(4000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;});
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 2;});
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(4000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 3;});
        Stream.of(future.get(), future1.get(), future2.get()).forEach(System.out::println);
    }
}
