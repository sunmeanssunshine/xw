package study.concurrent;

/**
 * Created by xuwei on 2017/6/15.
 */
public class LiftOff implements Runnable {
    private int countDown = 5;
    private static int taskCount = 0;
    private final int id = taskCount++;
    public LiftOff(){}
    public LiftOff(int countDown){
        this.countDown = countDown;
    }
    public String status(){
        return "#" + id + "(" +
                (countDown > 0 ? countDown : "LiftOff!") + ")   ";
    }
    @Override
    public void run() {
        while (countDown-- > 0){
            System.out.print(status());
        }
    }

    public static void main(String[] args) {
        LiftOff launch = new LiftOff();
        launch.run();
    }
}
