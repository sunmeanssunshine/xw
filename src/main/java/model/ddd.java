package model;

import java.util.*;


/**
 * Created by xuwei on 2017/2/27.
 */
public class ddd {
    public static void main(String[] args) {
        Set<String> all = new HashSet<>();
        all.addAll(Arrays.asList("1","2","3","4"));
        Set<String> part = new HashSet<>();
        part.addAll(Arrays.asList("1","2","3","5"));

        all.removeAll(part);
        for(String s: all){
            System.out.println(s);
        }

        ddd.f("a,a1,a2","dd");


//        List<Child> childList = new ArrayList<>();
//        Father father = new Father();
//        father.setFa("fa");
//        father.setFb("fb");
//        childList.add((Child) father);

        List<Father> fatherList = new ArrayList<>();
        Child child = new Child();
        child.setA(1);
        child.setFb("fb");
        child.setFa("fa");
        fatherList.add(child);
        System.out.print(fatherList.get(0).getFa());
    }

    public static void  f(String a, String b){
        List<String> aa = Arrays.asList(a.split(","));
        List<String> bb = Arrays.asList(b.split(","));
        System.out.println(aa.get(0));
        System.out.println(bb.get(0));
    }
}
