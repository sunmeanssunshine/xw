package study;

import com.google.common.collect.Sets;

import java.util.Set;
import java.util.stream.IntStream;

/**
 * Created by xuwei on 2017/6/14.
 */
@SuppressWarnings("DefaultFileTemplate")
public class SetTest {
    public static void main(String[] args) {
        Set<Long> set = Sets.newTreeSet(Long::compareTo);
        set.add(2L);
        set.add(1L);
        set.add(3L);
        set.add(0L);
        set.stream().forEach(System.out::println);

        IntStream.range(0, 10).forEach(System.out::println);
    }
}
