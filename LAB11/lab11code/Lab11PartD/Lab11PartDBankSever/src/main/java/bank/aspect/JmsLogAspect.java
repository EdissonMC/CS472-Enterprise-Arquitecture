package bank.aspect;

import bank.logging.ILogger;
import bank.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class JmsLogAspect {

    @Autowired
    private ILogger logger;


    @After("execution(* bank.jms.JMSSender.sendJMSMessage(..)) && args(text)")
    public void logAfter(JoinPoint joinPoint, String text) {
        System.out.println("");
//        System.out.println("--------------------------LOGGER AFTER JMS");
        logger.log("-> Log JMS Message " +
                text  );
    }


}
