package bank.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

@Aspect
@Configuration
public class TimerAspect {

    private Logger logger = LoggerFactory.getLogger(TimerAspect.class);

    @Around("execution(* bank.service.*.*(..))")
    public Object time(ProceedingJoinPoint method) throws Throwable {
        // Inicialiting Timer
        StopWatch sw = new StopWatch();

        // Starting Timer
        sw.start(method.getSignature().getName());

        // Execution of method
        Object retVal = method.proceed();

        // Stoping the Timer
        sw.stop();

        long totaltime = sw.getTotalTimeMillis();

        logger.trace("-> Time execution of method :"
                            + method.getSignature().getName() + " is "
                            + totaltime + " ms");

        return retVal;
    }

}
