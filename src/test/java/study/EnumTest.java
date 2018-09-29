package study;

import org.junit.Test;

import java.io.File;
import java.util.*;

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
}
