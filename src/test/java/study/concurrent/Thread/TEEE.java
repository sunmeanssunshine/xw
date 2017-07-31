package study.concurrent.Thread;



/**
 * Created by xuwei on 2017/7/24.
 */
public class TEEE {
    public static void main(String[] args){
        ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

        threadLocal.set("666");
        System.out.println(Thread.currentThread().getName() + ": " + threadLocal.get());

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ": " + threadLocal.get());
            }
        });
        thread.start();
    }
}
