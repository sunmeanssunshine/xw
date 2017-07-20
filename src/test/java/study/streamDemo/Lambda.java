package study.streamDemo;

import com.google.common.collect.Lists;
import model.Child;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.toList;


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

    public static void main(String[] args) throws IOException {
        List<Child> childList = Lists.newArrayList();
        Child child = new Child();
        child.setA(1);child.setLength(1);child.setStatus("success");child.setTime(11L);childList.add(child);
        Child child1 = new Child();
        child1.setA(2);child1.setLength(1);child1.setStatus("success");child1.setTime(22L);childList.add(child1);
        Child child2 = new Child();
        child2.setA(3);child2.setLength(1);child2.setStatus("success");child2.setTime(23L);childList.add(child2);
        Child child3 = new Child();
        child3.setA(4);child3.setLength(1);child3.setStatus("success");child3.setTime(32L);childList.add(child3);
        Child child4 = new Child();
        child4.setA(5);child4.setLength(2);child4.setStatus("success");child4.setTime(42L);childList.add(child4);
        Child child5 = new Child();
        child5.setA(6);child5.setLength(2);child5.setStatus("success");child5.setTime(25L);childList.add(child5);
        Child child6 = new Child();
        child6.setA(7);child6.setLength(2);child6.setStatus("success");child6.setTime(12L);childList.add(child6);
        Child child7 = new Child();
        child7.setA(8);child7.setLength(2);child7.setStatus("success");child7.setTime(22L);childList.add(child7);
        Child child8 = new Child();
        child8.setA(9);child8.setLength(2);child8.setStatus("success");child8.setTime(44L);childList.add(child8);
        Child child9 = new Child();
        child9.setA(10);child9.setLength(2);child9.setStatus("success");child9.setTime(62L);childList.add(child9);
        Child child10 = new Child();
        child10.setA(11);child10.setLength(2);child10.setStatus("success");child10.setTime(12L);childList.add(child10);
        Child child11 = new Child();
        child11.setA(12);child11.setLength(3);child11.setStatus("processing");child11.setTime(72L);childList.add(child11);
        Child child12 = new Child();
        child12.setA(13);child12.setLength(3);child12.setStatus("success");child12.setTime(14L);childList.add(child12);
        Child child13 = new Child();
        child13.setA(14);child13.setLength(3);child13.setStatus("success");child13.setTime(41L);childList.add(child13);
        Child child14 = new Child();
        child14.setA(15);child14.setLength(3);child14.setStatus("processing");child14.setTime(722L);childList.add(child14);
        Child child15 = new Child();
        child15.setA(16);child15.setLength(3);child15.setStatus("success");child15.setTime(512L);childList.add(child15);
        Child child16 = new Child();
        child16.setA(17);child16.setLength(3);child16.setStatus("processing");child16.setTime(215L);childList.add(child16);
        Child child17 = new Child();
        child17.setA(18);child17.setLength(3);child17.setStatus("success");child17.setTime(252L);childList.add(child17);
        Child child18 = new Child();
        child18.setA(19);child18.setLength(3);child18.setStatus("success");child18.setTime(262L);childList.add(child18);
        Child child19 = new Child();
        child19.setA(20);child19.setLength(4);child19.setStatus("processing");child19.setTime(212L);childList.add(child19);
        Child child20 = new Child();
        child20.setA(21);child20.setLength(4);child20.setStatus("processing");child20.setTime(622L);childList.add(child20);
        Child child21 = new Child();
        child21.setA(22);child21.setLength(4);child21.setStatus("processing");child21.setTime(122L);childList.add(child21);
        Map<Integer, List<Child>> map = childList.stream().collect(groupingBy(Child::getLength));
        List<Child> list = new ArrayList<>();
        for (Integer key : map.keySet()) {
            Optional<Child> childOptional = map.get(key).stream().max((c1, c2)->DefineComparator(c1, c2));
            list.add(childOptional.get());
        }

        for (Integer key : map.keySet()) {
            Optional<Child> childOptional = map.get(key).stream().collect(maxBy((c1, c2)->DefineComparator(c1, c2)));
            list.add(childOptional.get());
        }

        System.out.println(2);

        Stream.iterate(0, n -> n + 3).limit(10). forEach(x -> System.out.print(x + " "));

        Files.list(new File("../").toPath()).forEach(System.out::println);

        Stream.of("one", "two", "three", "four")
                         .filter(e -> e.length() > 2)
                         .peek(e -> System.out.println("Filtered value: " + e))
                         .map(String::toUpperCase)
                         .peek(e -> System.out.println("Mapped value: " + e))
                         .collect(toList());
        System.out.println("----------------------------------");
        Stream.of("d2", "a2", "a1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));

    }

    public static int DefineComparator(Child c1, Child c2){
        if (c1.getStatus().equals("success") && c2.getStatus().equals("success")){
            return c1.getTime().compareTo(c2.getTime());
        } else if (c1.getStatus().equals("success") && c2.getStatus().equals("processing")){
            return 1;
        } else if (c1.getStatus().equals("processing") && c2.getStatus().equals("success")){
            return -1;
        } else {
            return c1.getTime().compareTo(c2.getTime());
        }
    }


}
