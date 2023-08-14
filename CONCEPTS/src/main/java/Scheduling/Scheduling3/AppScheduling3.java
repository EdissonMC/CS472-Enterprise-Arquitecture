package Scheduling.Scheduling3;

import JPAMappings.OneToMany.Example1.AppMappingE1;
import org.quartz.JobDetail;
import org.quartz.impl.JobDetailImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class AppScheduling3  implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(AppScheduling3.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("using crons");
    }

}
