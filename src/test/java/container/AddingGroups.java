package container;

import java.util.Arrays;
import java.util.List;

/**
 * Created by xuwei on 2017/4/1.
 */
public class AddingGroups {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4);
        list.set(0, 10);
        list.forEach(System.out :: println);
        list.add(5);//error unSupportedOperation
    }
}
