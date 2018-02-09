package study.concurrent.Thread;

/**
 * Created by xuwei on 2018/2/9.
 */
public class JoinCountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> System.out.println("thread1"));
        Thread thread2 = new Thread(() -> System.out.println("thread2"));
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("main");
    }
}
