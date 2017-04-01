package proxy.cglib;

/**
 * Created by xuwei on 2017/4/1.
 */
public class TestCglib {
    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        DoSomethingImpl doSomethingCglib = (DoSomethingImpl) cglibProxy.getInstance(new DoSomethingImpl());
        doSomethingCglib.doSomething1();
    }
}
