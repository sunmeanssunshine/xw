/**
 * Created by xuwei on 2017/9/30.
 */
public class ThreadLocalTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadLocal<String> threadLocal= new ThreadLocal<>();
        threadLocal.set(99 +"");

        for (int i=0; i<100000000; i++) {
            Thread thread = new Thread(new MyThread(threadLocal, i +""));
        thread.start();
    }

    System.out.println(threadLocal.get());
    }
}
