package study.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xuwei on 2017/6/15.
 */
public class MyExecutor extends Thread {
    private int index;
    public MyExecutor(int i){
        this.index=i;
    }
    public void run(){
        try{
            System.out.println("["+this.index+"] start....");
            Thread.sleep((int)(Math.random()*30000));
            System.out.println("["+this.index+"] end.");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String args[]){
        ExecutorService service= Executors.newFixedThreadPool(4);
        //ExecutorService service= Executors.newSingleThreadExecutor();
        for(int i=0;i<10;i++){
            service.execute(new MyExecutor(i));
            service.submit(new MyExecutor(i));
        }
        System.out.println("submit finish");

        service.execute(() -> System.out.println("aaa")); service.shutdown();
    }
}
