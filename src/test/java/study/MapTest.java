package study;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by xuw-e on 2018/10/9.
 */
public class MapTest {
    @Test
    public void hashMapTest() {
        Map<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(1,1);
        hashMap.put(2,2);
        hashMap.put(5,3);
        hashMap.put(4,4);
        hashMap.keySet().forEach(k -> System.out.println(k));
        /** 根据hash值顺序
         * 1
         * 2
         * 4
         * 5
         */


        Map<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1,1);
        linkedHashMap.put(2,2);
        linkedHashMap.put(5,3);
        linkedHashMap.put(4,4);
        linkedHashMap.keySet().forEach(k -> System.out.println(k));
        /** 保留添加顺序
         * 1
         * 2
         * 5
         * 4
         */
    }
}
