package forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Created by xuwei on 2017/7/17.
 */
public class CountTask extends RecursiveTask<Long> {
    private static final Long THRESHOLD = 200L;
    private Long start;
    private Long end;

    public CountTask(Long start, Long end){
        this.start = start;
        this.end = end;
    }


    @Override
    protected Long compute() {
        Long sum = 0L;
        boolean canCompute = (end - start) <= THRESHOLD;
        if (canCompute){
            for (Long i=start; i<=end; i++){
                sum += i;
            }
        }else {
            Long mid = (start + end)/2;
            CountTask leftTask = new CountTask(start, mid);
            CountTask rightTask = new CountTask(mid+1, end);
            leftTask.fork();
            rightTask.fork();

            Long leftResult = leftTask.join();
            Long rightResult = rightTask.join();
            sum = leftResult + rightResult;
        }

        return sum;
    }

    public static Long commonCompute(Long start, Long end){
        Long sum = 0L;
        for (Long i=start; i<=end; i++){
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Long t1 = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        CountTask task = new CountTask(1L,50_000_000L);
        Future<Long> result = forkJoinPool.submit(task);
        Long t2 = System.currentTimeMillis() - t1;
        try {
            System.out.println("forkjoin  time: " + t2 + " result: " +result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        Long t3 = System.currentTimeMillis();
        Long resultCommon = CountTask.commonCompute(1L, 40000000L);
        Long t4 = System.currentTimeMillis() - t3;
        System.out.println("common  time: " + t4 + " result: " + resultCommon);

    }
}
