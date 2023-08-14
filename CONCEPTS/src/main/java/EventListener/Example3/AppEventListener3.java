package EventListener.Example3;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppEventListener3  implements CommandLineRunner {

    @Autowired
    private FlightService flightService;
    public static void main(String[] args) {
        SpringApplication.run(AppEventListener3.class,args);
    }
    @Override
    public void run(String... args) throws Exception {
        flightService.purchaseFlight();
    }
}
