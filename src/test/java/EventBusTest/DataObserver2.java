package EventBusTest;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;

/**
 * Created by xuwei on 2018/1/15.
 */
public class DataObserver2 {
    @Subscribe
    @AllowConcurrentEvents
    public void func(Integer msg) {
        System.out.println("DataObserver2 Integer msg: " + msg);
    }
}
