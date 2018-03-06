package guava;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multiset;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xuwei on 2018/2/27.
 */
public class ImmutableCollections {

    @Test
    public void test1() {
        ImmutableSet.of(1,2,3,4);
    }


    @Test
    public void Multiset() {
        // traditional java idiom
        List<String> words = Arrays.asList("a", "b", "a", "c", "ab", "d", "c");
        Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            Integer count = counts.get(word);
            if (count == null) {
                counts.put(word, 1);
            } else {
                counts.put(word, count + 1);
            }
        }

        //multiset
        Multiset<String> multiset = HashMultiset.create(Arrays.asList("a", "b", "a", "c", "ab", "d", "c"));
        System.out.println(multiset.count("a"));
        System.out.println(multiset.size());
    }
}
