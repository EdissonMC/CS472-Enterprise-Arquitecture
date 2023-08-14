package bank.controller;


import bank.domain.Account;
import bank.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Random;

@RestController
public class AccountController {

    Integer counter = 0;
    @Autowired
    IAccountService accountService;

    @PostMapping("/accounts/{name}")
    public ResponseEntity<?> createAccount(@PathVariable String name) {

        System.out.println(name);

        Random rand = new Random();

        int accountNumber = rand.nextInt(89000);
        Account account = accountService.createAccount(accountNumber, name);

        return new ResponseEntity<Account>(account, HttpStatus.OK);
    }

    @GetMapping("/accounts")
    public ResponseEntity<?> getAccounts() {
        counter++;
        System.out.println("Request getAccounts" + counter);
        Collection<Account> accountlist = accountService.getAllAccounts();
//        return new ResponseEntity<String>("hello", HttpStatus.OK);
        return new ResponseEntity<Collection<Account>>(accountlist, HttpStatus.OK);
    }

    @GetMapping("/accounts/{accountNumber}")
    public ResponseEntity<?> getAccount(@PathVariable Long accountNumber) {
        counter++;
        System.out.println("Request getAccount" + counter);
        Account account = accountService.getAccount(accountNumber);
        return new ResponseEntity<Account>(account, HttpStatus.OK);
    }


    @PostMapping("/accounts/deposit/{accountNumber}/{amount}")
    public ResponseEntity<?> deposit(@PathVariable Long accountNumber, @PathVariable Double amount) {
        counter++;
        System.out.println("Request deposit" + counter);
        System.out.println("accountNumber" + accountNumber);
        System.out.println("amount" + amount);

        if (accountNumber == 0 || amount == 0) {
            return new ResponseEntity<CustomErrorType>(
                    new CustomErrorType("Erro account invalid"),
                    HttpStatus.NOT_ACCEPTABLE);
        }
        accountService.deposit(accountNumber, amount);
        return new ResponseEntity<>("DEPOSITE SUCCESS", HttpStatus.OK);
    }

    @PostMapping("/accounts/deposit_euros/{accountNumber}/{amount}")
    public ResponseEntity<?> depositEuros(@PathVariable Long accountNumber, @PathVariable Double amount) {
        counter++;
        System.out.println("Request deposit Euros" + counter);
        System.out.println("accountNumber" + accountNumber);
        System.out.println("amount" + amount);

        if (accountNumber == 0 || amount == 0) {
            return new ResponseEntity<CustomErrorType>(
                    new CustomErrorType("Erro account invalid"),
                    HttpStatus.NOT_ACCEPTABLE);
        }
        accountService.deposit(accountNumber, amount);
        return new ResponseEntity<>("DEPOSITE IN EUROS SUCCESS", HttpStatus.OK);
    }

    @PostMapping("/accounts/withdraw/{accountNumber}/{amount}")
    public ResponseEntity<?> withdraw(@PathVariable Long accountNumber, @PathVariable Double amount) {
        counter++;
        System.out.println("Request withdraw" + counter);
        System.out.println("accountNumber" + accountNumber);
        System.out.println("amount" + amount);

        if (accountNumber == 0 || amount == 0) {
            return new ResponseEntity<CustomErrorType>(
                    new CustomErrorType("Error account OR amount invalid"),
                    HttpStatus.NOT_ACCEPTABLE);
        }
        accountService.withdraw(accountNumber, amount);

        return new ResponseEntity<>("WITHDRAW SUCCESS", HttpStatus.OK);
    }


    @PostMapping("/accounts/withdraw_euros/{accountNumber}/{amount}")
    public ResponseEntity<?> withdrawEuros(@PathVariable Long accountNumber, @PathVariable Double amount) {
        counter++;
        System.out.println("Request withdraw euros" + counter);
        System.out.println("accountNumber" + accountNumber);
        System.out.println("amount" + amount);

        if (accountNumber == 0 || amount == 0) {
            return new ResponseEntity<CustomErrorType>(
                    new CustomErrorType("Error account OR amount invalid"),
                    HttpStatus.NOT_ACCEPTABLE);
        }

        accountService.withdrawEuros(accountNumber, amount);
        return new ResponseEntity<>("WITHDRAW WITH EUROS SUCCESS", HttpStatus.OK);
    }


    @PostMapping("/accounts/transfer/{accountNumber1}/{accountNumber2}/{description}/{amount}")
    public ResponseEntity<?> transferFunds(@PathVariable Long accountNumber1,
                                           @PathVariable Long accountNumber2,
                                           @PathVariable String description,
                                           @PathVariable Double amount) {
        counter++;
        System.out.println("Request transferFunds " + counter);
        System.out.println("accountNumber1" + accountNumber1);
        System.out.println("accountNumber2" + accountNumber2);
        System.out.println("amount" + amount);

        if (accountNumber1 == 0 || accountNumber2 == 0 || amount == 0) {
            return new ResponseEntity<CustomErrorType>(
                    new CustomErrorType("Error account OR amount invalid"),
                    HttpStatus.NOT_ACCEPTABLE);
        }

        accountService.transferFunds(accountNumber1,
                accountNumber2,
                amount,
                description);

        return new ResponseEntity<>("TRANFER FUNDS SUCCESS", HttpStatus.OK);

    }

}
