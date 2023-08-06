package EventListener.Example1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppEventListener1 implements CommandLineRunner {

    @Autowired
    MyPublisher publisher1;

    public static void main(String[] args) {
        SpringApplication.run(AppEventListener1.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Before event");
        publisher1.puublishEventGo("hello mundo");
        System.out.println("After event");
    }
}
