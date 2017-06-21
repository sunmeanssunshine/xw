package study.concurrent.Thread;

/**
 * Created by xuwei on 2017/6/20.
 */
public class ThreadTest extends Thread{
    public static ThreadLocal<Integer> thLocal = new ThreadLocal<>();
    public static ThreadLocal<String> thLocal2 = new ThreadLocal<>();

    public Integer num;

    public String str;

    public ThreadTest(Integer num) {
        super("线程" + num);
        this.num = num;
        this.str = String.valueOf(num);
    }

    @Override
    public void run() {
        Integer n = thLocal.get();
        String s = thLocal2.get();

        if(n == null) {
            thLocal.set(num);
        }
        if (s == null){
            thLocal2.set(str);
        }
        System.out.println("num:" + thLocal.get() + " str: " + thLocal2.get());
    }
}
