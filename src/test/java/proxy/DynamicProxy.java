package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by xuwei on 2017/4/1.
 */
public class DynamicProxy implements InvocationHandler {
    private Object target;

    public Object bind(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;
        System.out.println("begin");
        System.out.println(target.toString() + " is dynamic class? result:" + Proxy.isProxyClass(target.getClass()));
        result = method.invoke(target, args);
        System.out.println("end");
        return result;
    }
}
