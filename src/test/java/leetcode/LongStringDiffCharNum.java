package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by xuw-e on 2018/9/28.
 */
public class LongStringDiffCharNum {
    public static void main(String[] args) {
        String s = "pwwkew";
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int length = s.length();
        for (int i=0, j=0; i< length; i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
    }
}
