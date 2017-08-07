package forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;
import java.util.function.LongSupplier;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by xuwei on 2017/7/17.
 */
public class CountTask extends RecursiveTask<Long> {
    private static final Long THRESHOLD = 1_000_000L;
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

    public static Long parallelCompute(Long start, Long end){
        return  LongStream.range(start, end).parallel().sum();
    }

    public static void main(String[] args) {

        ForkJoinPool forkJoinPool = new ForkJoinPool();

        CountTask task = new CountTask(1L,50_000_000L);
        Long t1 = System.currentTimeMillis();
        Future<Long> result = forkJoinPool.submit(task);
        try {
            Long reslut = result.get();
            Long t2 = System.currentTimeMillis() - t1;
            System.out.println(" result: " + reslut + "  forkjoin  time: " + t2 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        Long t3 = System.currentTimeMillis();
        Long resultCommon = CountTask.commonCompute(1L, 50_000_000L);
        Long t4 = System.currentTimeMillis() - t3;
        System.out.println(" result: " + resultCommon + " common  time: " + t4);

        Long t5 = System.currentTimeMillis();
        Long resultParallel = CountTask.parallelCompute(1L, 50_000_001L);
        Long t6 = System.currentTimeMillis() - t5;
        System.out.println(" result: " + resultParallel + " parallel  time: " + t6);



    }
}
