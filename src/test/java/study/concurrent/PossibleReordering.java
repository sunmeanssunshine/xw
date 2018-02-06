package study.concurrent;

import java.util.StringJoiner;

/**
 * Created by xuwei on 2018/1/17.
 */
public class PossibleReordering {
    public static int x = 0, y = 0;
    public static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread one = new Thread(new Runnable() {
            @Override
            public void run() {
                a = 1;
                x = b;
            }
        });

        Thread two = new Thread(new Runnable() {
            @Override
            public void run() {
                b = 1;
                y = a;
            }
        });

        one.start();
        two.start();
        one.join();
        two.join();
        //Thread.sleep(1_000L);

        System.out.println(x + "," + y);
    }
}
