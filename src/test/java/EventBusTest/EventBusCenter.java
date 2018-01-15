package EventBusTest;

import com.google.common.eventbus.EventBus;

/**
 * Created by xuwei on 2018/1/15.
 */
public class EventBusCenter {
    private static EventBus eventBus = new EventBus();
    private EventBusCenter() {}

    public static EventBus getInstance() {
        return eventBus;
    }

    public static void register(Object object) {
        eventBus.register(object);
    }

    public static void unregister(Object object) {
        eventBus.unregister(object);
    }

    public static void post(Object object) {
        eventBus.post(object);
    }
}
