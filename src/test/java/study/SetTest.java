package study;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import model.Child;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

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
        set.add(7L);
        set.add(4L);
        set.stream().forEach(System.out::println);

        Set<Child> childSet = Sets.newTreeSet(new Comparator<Child>() {
            @Override
            public int compare(Child o1, Child o2) {
                return o1.getLength() > o2.getLength() ? 1:0;
            }
        });
        Child child1 = new Child(1,2,"a",4L);
        Child child2 = new Child(3,4,"b",3L);
        Child child3 = new Child(4,3,"c",5L);
        Child child4 = new Child(2,8,"d",5L);
        childSet.add(child1);
        childSet.add(child4);
        childSet.add(child3);
        childSet.add(child2);
        childSet.stream().forEach(System.out::println);

        List<Long> list = Lists.newArrayList();
        list.addAll(set);
        list.stream().filter(n->n>3).forEach(System.out::println);
    }
}
