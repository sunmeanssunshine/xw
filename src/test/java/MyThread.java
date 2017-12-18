import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuwei on 2017/9/30.
 */
public class MyThread implements Runnable {
    String[] strings = new String[50*1024*1024];
    StaticClassTest.StaticA staticA = null;
    ThreadLocal<String> threadLocal;
    String str;

    MyThread(ThreadLocal<String> threadLocal, String str){
        this.threadLocal = threadLocal;
        this.str = str;
    }
    @Override
    public void run() {
        threadLocal.set(str);
        doOthers();
    }

    void doOthers(){
        for (int i = 0; i < 1000000000; i++) {

        }
        System.out.println(threadLocal.get());
    }
}
