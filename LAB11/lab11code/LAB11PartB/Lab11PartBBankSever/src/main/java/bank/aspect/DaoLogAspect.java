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
public class DaoLogAspect {


    @Autowired
    private ILogger logger;

    //a) Log every call to any method in the bank.dao package (using the Logger).
    @After("execution(* bank.dao.*.*(..))")
    public void logAfter(JoinPoint joinPoint){
        logger.log(
                "-> Logger after called to :"
                        + joinPoint.getSignature().getName()
                        + " on " + joinPoint.getTarget().getClass());
    }
}
