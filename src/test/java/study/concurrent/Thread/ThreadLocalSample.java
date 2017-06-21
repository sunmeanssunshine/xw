package study.concurrent.Thread;

/**
 * Created by xuwei on 2017/6/20.
 */
public class ThreadLocalSample {
    public static void main(String[] args) {
        ThreadTest test1 = new ThreadTest(10);
        ThreadTest test2 = new ThreadTest(20);
        test1.start();
        test2.start();
    }
}
