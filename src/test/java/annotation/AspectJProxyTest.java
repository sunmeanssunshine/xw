package annotation;

import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

/**
 * Created by xuwei on 2017/9/29.
 */
public class AspectJProxyTest {

    @Test
    public void proxy() {
        Waiter waiter = new NaiveWaiter();

        AspectJProxyFactory factory = new AspectJProxyFactory();
        factory.setTarget(waiter);
        factory.addAspect(PreGreetingAspect.class);

        Waiter proxy = factory.getProxy();

        proxy.greetTo("haha");
        proxy.serveTo("haha");

    }
}
