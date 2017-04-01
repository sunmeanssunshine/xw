package proxy;

/**
 * Created by xuwei on 2017/4/1.
 */
public class TestProxy {
    public static void main(String[] args) {
        DynamicProxy proxy = new DynamicProxy();
        BookFacade bookFacade = (BookFacade) proxy.bind(new BookFacadeImpl());
        bookFacade.addBook();

        Fly fly = (Fly) proxy.bind(new FlyImpl());
        fly.canFly();
    }
}
