package annotation;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * Created by xuwei on 2017/9/29.
 */
public class ToolTest {
    @Test
    public void tool() {
        Class clazz = B.class;

        Method[] methods = clazz.getMethods();
        System.out.println(methods.length);
        for (Method method: methods) {
            NeedTest needTest = method.getAnnotation(NeedTest.class);
            if (needTest != null) {
                if (needTest.value()) {
                    System.out.println(method.getName() + "需要测试");
                } else {
                    System.out.println(method.getName() + "不需要测试");
                }
            }
        }
    }
}
