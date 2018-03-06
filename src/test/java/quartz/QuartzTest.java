package quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

/**
 * Created by xuwei on 2018/3/2.
 */
public class QuartzTest {

    public static void main(String[] args) throws SchedulerException, InterruptedException {
        //create scheduler
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        //define Trigger
        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("trigger1","group1")
                .startNow()
                .withSchedule(simpleSchedule().withIntervalInSeconds(2).repeatForever())
                .build();

        //define job detail
        JobDetail jobDetail = newJob(MyJob.class)
                .withIdentity("job1", "group1")
                .usingJobData("name", "quartz")
                .build();

        scheduler.scheduleJob(jobDetail, trigger);

        scheduler.start();

        Thread.sleep(100_000L);

        scheduler.shutdown();

    }
}
