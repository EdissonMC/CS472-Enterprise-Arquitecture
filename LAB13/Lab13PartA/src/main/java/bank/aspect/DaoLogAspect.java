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
public class DaoLogAspect {
    private Logger logger = LoggerFactory.getLogger(DaoLogAspect.class);



    //a) Log every call to any method in the bank.dao package (using the Logger).
    @After("execution(* bank.dao.*.*(..))")
    public void logAfter(JoinPoint joinPoint){
        logger.trace(
                "-> Logger after called to :"
                        + joinPoint.getSignature().getName()
                        + " on " + joinPoint.getTarget().getClass());
    }
}
