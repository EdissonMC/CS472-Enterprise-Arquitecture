package RestApi;


import jdk.jshell.Snippet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ControllerWeb {

    @Autowired
    ServiceFlySystem serviceFlySystem;

    @PostMapping("/accounts/{customerName}")
    public ResponseEntity<?> createAccount(@PathVariable("customerName") String customerName) {
        System.out.println("-> Creating FrecuentlyFlierMiles account" + customerName);
        CustomerDTO customerDTO = serviceFlySystem.createCustomer(customerName);
        return new ResponseEntity<CustomerDTO>(customerDTO, HttpStatus.ACCEPTED);
    }


    @GetMapping("/accounts/{accountNumber}")
    public ResponseEntity<?> getAccount(@PathVariable("accountNumber") String accountNumber) {
        System.out.println("-> Get Account by account-Number" + accountNumber);

        CustomerDTO customerDTO = serviceFlySystem.findCustomer(accountNumber);
        return new ResponseEntity<CustomerDTO>(customerDTO, HttpStatus.ACCEPTED);
    }

    @PostMapping("/accounts")
    public ResponseEntity<?> setPoints(
            @RequestParam("operation") String operation,
            @RequestParam("accountNumber") String accountNumber,
            @RequestParam("numberOfPoints") String numberOfPoints
    ) {
        if (operation.equals("add")) {
            serviceFlySystem.addPoints(numberOfPoints);
        } else if (operation.equals("withdraw")) {
            serviceFlySystem.withdrawPoints(numberOfPoints);
        }
        CustomerDTO customerDTO = serviceFlySystem.findCustomer(accountNumber);

        return new ResponseEntity<CustomerDTO>(customerDTO, HttpStatus.OK);
    }

    @PostMapping("/accounts/{accountNumber}/buyticket")
    public ResponseEntity<?> purchaseTicket(
            @PathVariable("accountNumber") String accountNumber,
            @RequestParam("flightNumber") String flightNumber,
            @RequestParam("date") String date,
            @RequestParam("amountPoints") String amountPoints
    ) {

        FlightDTO flightDTO = serviceFlySystem.BuyTicket(accountNumber,
                                                        flightNumber,
                                                        date,
                                                        amountPoints);
        return new ResponseEntity<>(flightDTO, HttpStatus.OK);
    }


}



