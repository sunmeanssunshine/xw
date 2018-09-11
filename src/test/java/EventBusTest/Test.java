package EventBusTest;

import java.util.Objects;
import java.util.concurrent.atomic.LongAdder;

/**
 * Created by xuwei on 2018/1/15.
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {

        DataObserver1 observer1 = new DataObserver1();
        DataObserver2 observer2 = new DataObserver2();

        EventBusCenter.register(observer1);
        EventBusCenter.register(observer2);

        System.out.println("============   start  ====================");

        // 只有注册的参数类型为String的方法会被调用
        EventBusCenter.post("post string method");
        EventBusCenter.post(123);

        System.out.println("============ after unregister ============");
        // 注销observer2
        EventBusCenter.unregister(observer2);
        EventBusCenter.post("post string method");
        EventBusCenter.post(123);

        System.out.println("============    end           =============");
    }

    @org.junit.Test
    public void test2() {
        DataObserver1 observer1 = new DataObserver1();
        EventBusCenter.register(observer1);

        EventBusCenter.post("test2");
    }

    @org.junit.Test
    public void test3() {
        System.out.println(Objects.deepEquals("1", "1"));
        LongAdder longAdder = new LongAdder();
        longAdder.decrement();
        System.out.println(longAdder);
    }
}
