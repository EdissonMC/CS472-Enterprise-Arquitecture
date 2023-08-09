package Lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class App implements CommandLineRunner {
	@Autowired
	private AppProperties appProperties;
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		appProperties.showProperties();
	}
}
