package bank.aspect;

import bank.logging.ILogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class JmsLogAspect {

    private Logger logger = LoggerFactory.getLogger(JmsLogAspect.class);

    @After("execution(* bank.jms.JMSSender.sendJMSMessage(..)) && args(text)")
    public void logAfter(JoinPoint joinPoint, String text) {
        System.out.println("");
//        System.out.println("--------------------------LOGGER AFTER JMS");
        logger.trace("-> Log JMS Message " +
                text  );
    }


}
