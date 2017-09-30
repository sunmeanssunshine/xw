package annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by xuwei on 2017/9/29.
 */
@Aspect
public class PreGreetingAspect {

    @Before("execution(* greetTo(..))")
    public void beforeGreeting() {
        System.out.println("how are you");
    }
}
