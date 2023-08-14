package Scheduling.Scheduling3;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@Component
public class Task3 {

    //    @Scheduled(cron = "1 * * * * *")
//    public void scheduleTaskUsingCronExpression() {
//
//        long now = System.currentTimeMillis() / 1000;
//        System.out.println(
//                "schedule tasks using cron jobs -> " + now);
//    }
    int counter = 0;

//    @Async
    @Scheduled(cron = "*/1 * * * * *")
    public void runEvey5Minutes() throws InterruptedException {
        counter++;
        System.out.println("---------> Starting a task  " + counter);
        Thread.sleep(7000);

//        System.out.println("Current time is :: " + LocalDate.now());
        Date date = Calendar.getInstance().getTime();
        DateFormat timeFormatter = DateFormat.getTimeInstance(DateFormat.DEFAULT);
        String currenttime = timeFormatter.format(date);
        System.out.println("This task runs at " + currenttime);
    }

}
