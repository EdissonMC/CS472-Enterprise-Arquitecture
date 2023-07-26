package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
//
//@SpringBootApplication
//public class Lab2PartAApplication  {
//
//
//	public static void main(String[] args) {
//
//		SpringApplication.run(Lab2PartAApplication.class, args);
//		ApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
//
//		ICustomerService customerService = context.getBean("customerService",
//				ICustomerService.class);
//
//		customerService.addCustomer("Frank Brown", "fbrown@acme.com",
//				"mainstreet 5", "Chicago", "60613");
//
//	}
//
//
//}


@SpringBootApplication
public class Lab2PartAApplication implements CommandLineRunner {

	@Autowired
	private ICustomerService customerService;

	public static void main(String[] args) {
		SpringApplication.run(Lab2PartAApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		customerService.addCustomer(
				"Frank Brown",
				"fbrown@acme.com",
				"mainstreet 5",
				"Chicago",
				"60613");
	}
}
