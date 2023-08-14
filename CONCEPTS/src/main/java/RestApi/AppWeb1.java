package RestApi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppWeb1 implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(AppWeb1.class, args);
        System.out.println("Server its running....");
    }

    @Override
    public void run(String[] args){

    }
}
