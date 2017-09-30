package annotation;

/**
 * Created by xuwei on 2017/9/29.
 */
public class NaiveWaiter implements Waiter {
    @Override
    public void greetTo(String clientName) {
        System.out.println(clientName + "...");
    }

    @Override
    public void serveTo(String clientName) {
        System.out.println(clientName + "...");
    }
}
