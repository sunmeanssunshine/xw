package study;

import java.util.Arrays;
import java.util.List;

/**
 * Created by xuwei on 2017/1/16.
 */
public class Lambda {
    private final String lam = "Lambda";

    Runnable runnable1 = () -> System.out.println(this.lam);
    Runnable runnable2 = () -> System.out.println(toString());

    public String toString() {
        return "Hello world";
    }

    public static void main(String[] args) {
        new Lambda().runnable1.run();
        new Lambda().runnable2.run();
        Arrays.asList("a", "b", "c")
                .forEach(e-> {System.out.println(e);System.out.println(e);});
        List<String> list = Arrays.asList("d", "e", "f");
        for (String s: list) {
            System.out.println(s);
        }
    }
}
