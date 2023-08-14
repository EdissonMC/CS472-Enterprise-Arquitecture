package kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class App implements CommandLineRunner {
    @Autowired
    SenderTransaction senderTransaction;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        // TRANSACTION: create account
        AccountTransaction createAccount = new AccountTransaction(
                                                123L,
                                                "createAccount",
                                                "Panchito");
        String createAccountAsString = objectMapper.writeValueAsString(createAccount);
        System.out.println("-> Sending to Kafka an message of operation :" + createAccountAsString);
        senderTransaction.send("transations", createAccountAsString);


        // TRANSACTION: deposit on account
        AccountTransaction deposit = new AccountTransaction(
                                                    123L,
                                                    "deposit",
                                                    100.0);
        String depositAsString = objectMapper.writeValueAsString(deposit);
        System.out.println("-> Sending to Kafka an message of operation :" + depositAsString);
        senderTransaction.send("transations", depositAsString);


        // TRANSACTION: withdraw from account
        AccountTransaction withdraw = new AccountTransaction(
                                                    123L,
                                                    "withdraw",
                                                    10.0);
        String withdrawAsString = objectMapper.writeValueAsString(withdraw);
        System.out.println("-> Sending to Kafka an message of operation :" + withdrawAsString);
        senderTransaction.send("transations", withdrawAsString);

    }
}
