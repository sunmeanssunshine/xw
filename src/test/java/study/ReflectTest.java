package study;

import model.Child;
import model.Father;

import javax.sound.midi.Soundbank;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by xuwei on 2017/3/31.
 */
public class ReflectTest {
    public static void main(String[] args) throws ClassNotFoundException {
        Class c = Child.class;
        //获取所有方法（不含构造器）
        Method method[] = c.getDeclaredMethods();
        System.out.println(Arrays.toString(method));

        //获取所有构造器
        Constructor[] constructors = c.getConstructors();
        System.out.println(Arrays.toString(constructors));

        //获取父类
        Class<?> superClass = c.getSuperclass();
        System.out.println(superClass);

        Method superClassMethod[] = superClass.getDeclaredMethods();
        System.out.println(Arrays.toString(superClassMethod));

        Field field[] = superClass.getDeclaredFields();
        System.out.println(Arrays.toString(field));

    }
}
