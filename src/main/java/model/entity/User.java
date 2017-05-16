package model.entity;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by xuwei on 2017/5/16.
 */

public class User {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!id.equals(user.id)) return false;
        return name.equals(user.name);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    public static void main(String[] args) {
        User user = new User();
        user.setId("1");
        user.setName("1.1");
        User user1 = new User();
        user1.setId("1");
        user1.setName("1.1");
        Set<User> userSet = new HashSet<>();
        userSet.add(user);
        userSet.add(user1);
        System.out.println(userSet.size());

        ///---
        Set<String> stringSet = new HashSet<>();
        String str = "123";
        String str1 = new String("123");
        String str2 = new String(str);
        System.out.println("str1:" + str1.hashCode() + "   str2:" + str2.hashCode());
        stringSet.add(str1);
        stringSet.add(str2);
        System.out.println(stringSet.size());
    }
}
