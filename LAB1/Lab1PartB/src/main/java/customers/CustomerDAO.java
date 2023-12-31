package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("customerDAO")
public class CustomerDAO implements ICustomerDAO{
	private ILogger logger ;// new Logger();
	
	public void save(Customer customer) {
		// simple sleep
		try {
			Thread.sleep(350);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("CustomerDAO: saving customer "+customer.getName());
		logger.log("Customer is saved in the DB: "+ customer.getName() );
	}

	@Autowired
	public void setLogger(ILogger logger){
		this.logger= logger;
	}

}
