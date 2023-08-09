package bank;

import java.util.Collection;

import bank.domain.Account;
import bank.domain.AccountEntry;
import bank.domain.Accounts;
import bank.domain.Customer;
import bank.service.AccountDTO;
import bank.service.AccountService;
import bank.service.AccountsDTO;
import bank.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class Application implements CommandLineRunner {

    RestTemplate restTemplate = new RestTemplate();
    private String serverUrl = "http://127.0.0.1:8081/accounts";
    private String baseUrl = "http://127.0.0.1:8081";


    @Autowired
    IAccountService accountService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        /*
        *   GET AN ACCOUTN
        * */
//        Account account1 = restTemplate.getForObject(
//                                            serverUrl + "/{accountNumber}",
//                                                Account.class,
//                                                "4253892");
//        System.out.println(account1);

        
        //Create 1 an Account
//        String nameCustomer1= "charrito";
//         restTemplate.postForLocation(serverUrl + "/{customerName}", Account.class, nameCustomer1);

//        String nameCustomer2= "charrita";
//        restTemplate.postForLocation(serverUrl + "/accounts/{customerName}", Account.class, nameCustomer2);

        // Deposite into an Account
//        String accountNumber1="77980";
//        String amount1="100";
//        restTemplate.postForLocation(serverUrl + "/deposit/{accountNumber}/{amount}", Account.class, accountNumber1, amount1);

        // Withdraw from an Account
//        String accountNumber2="77980";
//        String amount2="40";
//        restTemplate.postForLocation(serverUrl + "/withdraw/{accountNumber}/{amount}", Account.class, accountNumber2, amount2);

//        AccountsDTO accounts = restTemplate.getForObject(serverUrl  , AccountsDTO.class);
//        System.out.println(accounts);

    }
}


