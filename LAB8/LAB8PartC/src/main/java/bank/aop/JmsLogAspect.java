package bank.aop;

import bank.logging.ILogger;
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
	
	
	@After("execution(* bank.jms.JMSSender.sendJMSMessage(..)) && args (message))")
	public void log(JoinPoint joinpoint, String text) {

		System.out.println("");
//        System.out.println("--------------------------LOGGER AFTER JMS");
		logger.log("-> Log JMS Message " +
				text  );
	}

}
