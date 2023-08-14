package bank.kafka;

import bank.service.AccountService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AccountListener {
    @Autowired
    AccountService accountService;

    @KafkaListener(topics = {"accountTopic"})
    public void handleMessage(String message) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {


            AccountTransaction transaction = objectMapper.readValue(message, AccountTransaction.class);
            System.out.println("-> Kafka Getting a message:" + transaction);



            switch (transaction.getOperation()) {
                case "createAccount":
                    accountService.createAccount(transaction.getAccountNumber(), transaction.getCustomerName());
                    break;
                case "deposit":
                    accountService.deposit(transaction.getAccountNumber(), transaction.getAmount());
                    break;
                case "withdraw":
                    accountService.withdraw(transaction.getAccountNumber(), transaction.getAmount());
                    break;
            }


        } catch (IOException e) {
            System.out.println("-> Kafka error, Cannot convert : " + message+" to a AccountInstruction object");
        }
    }
}

