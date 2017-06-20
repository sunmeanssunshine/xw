package study;

/**
 * Created by xuwei on 2017/6/5.
 */
public class AccountingSync implements Runnable{
    //共享资源(临界资源)
    static int i=0;

    /**
     * synchronized 修饰实例方法
     */
    public  void increase(){
        i++;
    }
    @Override
    public synchronized void run() {
        for(int j=0;j<1000000;j++){
            increase();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        AccountingSync instance=new AccountingSync();
        Thread t1=new Thread(instance);
        Thread t2=new Thread(instance);
        Thread t3=new Thread(instance);
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println(i);

        //-------------------

        Thread t5=new Thread(new AccountingSync());
        //new新实例
        Thread t6=new Thread(new AccountingSync());
        t5.start();
        t6.start();
        //join含义:当前线程A等待thread线程终止之后才能从thread.join()返回
        t5.join();
        t6.join();
        System.out.println(i);
    }
    /**
     * 输出结果:
     * 2000000
     */
}
