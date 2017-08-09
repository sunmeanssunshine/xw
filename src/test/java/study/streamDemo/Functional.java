package study.streamDemo;

/**
 * Created by xuwei on 2017/8/7.
 */
@FunctionalInterface
public interface Functional {
    void method();
    default void defaultMethod() {
//        init();
        System.out.println("defaultMethod");
    }
    static void staticMethod(){
        System.out.println("staticMethod");
    }
//    private void init(){
//        System.out.println("init");
//    }
}
