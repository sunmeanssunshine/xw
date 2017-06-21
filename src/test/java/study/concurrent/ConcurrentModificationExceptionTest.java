package study.concurrent;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by xuwei on 2017/6/21.
 */
public class ConcurrentModificationExceptionTest {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            Integer integer = iterator.next();
            if(integer==2)
                list.remove(integer);
        }
    }
}
