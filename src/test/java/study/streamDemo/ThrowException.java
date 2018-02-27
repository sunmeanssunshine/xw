package study.streamDemo;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by xuwei on 2018/2/27.
 */
public class ThrowException {
    @Test
    public void test() {
        Stream.of("1", "12", "123", "1234")
                .forEach(str -> delete(str));
    }

    @Test
    public void test1() {
        Stream.of("1", "12", "123", "1234")
                //.parallel()
                .map(str -> orginal(str))
                .collect(Collectors.toList());

    }

    @Test
    public void test2() {
        Arrays.asList(1,2,3,4).stream().map(e->e+1).forEach(System.out::println);
    }

    public void delete(String str) {
        if (str.equals("123"))
            throw new RuntimeException("123");
        System.out.println(str);
    }

    public String orginal(String str) {
        if (str.equals("123"))
            throw new RuntimeException("123");
        System.out.println(str);
        return str;
    }
}
