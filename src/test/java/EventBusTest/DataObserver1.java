package EventBusTest;

import com.google.common.eventbus.Subscribe;

/**
 * Created by xuwei on 2018/1/15.
 */
public class DataObserver1 {

    @Subscribe
    public void func(String msg) {
        System.out.println("DataObserver1 String msg: " + msg);
    }
}
