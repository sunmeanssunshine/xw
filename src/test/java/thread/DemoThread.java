package thread;

/**
 * Created by xuw-e on 2018/8/29.
 */
public class DemoThread {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("kkk");
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("ggg");

            }
        });
        thread.start();
        thread.start();

    }
}
