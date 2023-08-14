package Scheduling.Scheduling1;

import org.springframework.boot.SpringBootConfiguration;

import java.util.Timer;

@SpringBootConfiguration
public class AppScheduling1 {
    public static void main(String[] args) {

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new Task1(),1000,5000);
    }
}
