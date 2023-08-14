package RestApi;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class ServiceFlySystem {


    public CustomerDTO createCustomer(String nameCustomer) {

        return new CustomerDTO(nameCustomer);
    }

    public CustomerDTO findCustomer(String accountnumber) {
        CustomerDTO oldCustomer = new CustomerDTO("mock Customer with ID= " + accountnumber);//Mock data base customer
        return oldCustomer;
    }

    public void addPoints(String points) {

    }

    public void withdrawPoints(String points) {

    }

    public FlightDTO BuyTicket(String accountNumber,
                               String flightNumber,
                               String date,
                               String amountPoints) {

        return new FlightDTO();
    }

}
