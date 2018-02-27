package generics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuwei on 2018/2/27.
 */
public class FanXing {

    @Test
    public void test1() {
        List<String> list_str = new ArrayList<>();
        List<Integer> list_int = new ArrayList<>();
        System.out.println(list_int.getClass() == list_str.getClass());
    }
}
