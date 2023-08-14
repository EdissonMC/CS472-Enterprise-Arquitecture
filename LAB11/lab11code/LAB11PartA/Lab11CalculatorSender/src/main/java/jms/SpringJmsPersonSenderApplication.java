package jms;

import javax.jms.ConnectionFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import java.util.Optional;


@SpringBootApplication
@EnableJms
public class SpringJmsPersonSenderApplication implements CommandLineRunner {
    @Autowired
    JmsTemplate jmsTemplate;


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringJmsPersonSenderApplication.class, args);
        context.close();
    }

    @Override
    public void run(String... args) throws Exception {
//		Person person = new Person("Frank", "Brown");
//		//convert person to JSON string
//		ObjectMapper objectMapper = new ObjectMapper();
//		String personAsString = objectMapper.writeValueAsString(person);
        ObjectMapper mapper = new ObjectMapper();

        // MESSAGE #1
        CalculatorMessage calculatorMessage = new CalculatorMessage("+", 2);
        String message = mapper.writeValueAsString(calculatorMessage);
        System.out.println("Sending a JMS message:" + message);
        jmsTemplate.convertAndSend("testQueue", message);

        // MESSAGE #2
        calculatorMessage = new CalculatorMessage("+", 10);
        message = mapper.writeValueAsString(calculatorMessage);
        System.out.println("Sending a JMS message:" + message);
        jmsTemplate.convertAndSend("testQueue", message);

        // MESSAGE #3
        calculatorMessage = new CalculatorMessage("-", 2);
        message = mapper.writeValueAsString(calculatorMessage);
        System.out.println("Sending a JMS message:" + message);
        jmsTemplate.convertAndSend("testQueue", message);


    }

}
