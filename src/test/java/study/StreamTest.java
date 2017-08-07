package study;

import model.Father;
import model.entity.User;
import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by xuwei on 2017/2/21.
 */
public class StreamTest {
    public static void main(String[] args) {
        List<Integer> nums = Lists.newArrayList(1, null, 3, 4, null , 6);
        long count = nums.stream().filter(num -> num != null).count();
        System.out.println(Long.valueOf(count));
        Stream<Integer> integerStreamTest = Stream.of(1, 2, 3, 5);

        List<String> l = Stream.of("a","b","c","b")
                .distinct()
                .collect(Collectors.toList());
        System.out.println(l);

        Predicate<User> filter1 = (user -> true);
        Predicate<User> filter2 = filter1.and(filter1).negate().or(filter1);

        //Stream.of("1","2","3").filter(e-> )

        List<Father> fatherList = new ArrayList<>();
        Father father1 = new Father();
        father1.setFa("1");
        father1.setFb("1");
        father1.setSuffix("dwg");
        Father father2 = new Father();
        father2.setFa("2");
        father2.setFb("2");
        father2.setSuffix("dwg");
        Father father3 = new Father();
        father3.setFa("3");
        father3.setFb("3");
        father3.setSuffix("rvt");
        fatherList.add(father1);
        fatherList.add(father2);
        fatherList.add(father3);

        List<String> strings = fatherList.stream().filter(e->e.getSuffix().equals("rvt")).map(e->e.getFa()).collect(Collectors.toList());
        for (String s : strings){
            System.out.println(s);
        }

        List<String> a = new ArrayList<>(Arrays.asList("1","2","3","4"));
        List<String> b = new ArrayList<>(Arrays.asList("1","2","3","5"));
        a.removeAll(b);
        a.forEach(e-> System.out.println(e));

    }
}
