package study.serialization;

import lombok.Data;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * Created by xuw-e on 2018/10/8.
 */
@Data
public class Person implements Serializable {
    private String name;
    private int age;

    public static void main(String[] args) {
        Person person = new Person();
        person.setAge(11);
        person.setName("hh");

    }

    public static Object deserialize(byte[] sf) {
        try {
            return new ObjectInputStream(new ByteArrayInputStream(sf)).readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
