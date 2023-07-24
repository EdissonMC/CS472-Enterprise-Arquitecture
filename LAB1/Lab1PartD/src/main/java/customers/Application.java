package customers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"springconfig.xml");
//		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

		ICustomerService customerService = context.getBean("customerService",
				CustomerService.class);


		customerService.addCustomer("Frank Brown", "fbrown@acme.com",
				"mainstreet 5", "Chicago", "60613");
	}
}

