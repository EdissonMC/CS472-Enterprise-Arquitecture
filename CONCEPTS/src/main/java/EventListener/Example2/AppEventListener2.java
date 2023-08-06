package EventListener.Example2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class AppEventListener2 implements CommandLineRunner {

    @Autowired
    MyPublisher2 publisher;

    public static void main(String[] args) {
        SpringApplication.run(AppEventListener2.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Before...");
        publisher.emiteEvent("-> Starting emition of event #2");
        System.out.println("After...");
    }
}
