package study.streamDemo;

import rx.Completable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xuwei on 2017/8/7.
 */
public class FunctionalTest {
    public static void main(String[] args) {
        Functional f = new Functional() {
            @Override
            public void method() {
                for (int i=0; i<10; i++){
                    if (i==7){
                        continue;
                    }
                    System.out.println(i);
                }
            }
        };
        f.method();
        f.defaultMethod();
        Functional.staticMethod();
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("6");
        list.add("3");
        list.add("2");
        list.add("9");
        list.add("8");

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
    }
}
