package bank.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

@Aspect
@Configuration
public class TimerAspect {

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

        System.out.println("-> Time execution of method :"
                            + method.getSignature().getName() + " is "
                            + totaltime + " ms");

        return retVal;
    }

}
