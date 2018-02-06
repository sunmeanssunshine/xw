package web;

/**
 * Created by xuwei on 2018/2/5.
 */
public interface ThreadPool<Job extends Runnable> {
    void execute(Job job);
    void shutdown();
    void addWorkers(int num);
    void removeWorker(int num) throws IllegalAccessException;
    int getJobSize();
}
