package bank.aop;

import bank.logging.ILogger;
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
	


	@After("execution(* bank.dao.*.*(..))")
	public void log(JoinPoint joinpoint) {
		logger.log("-> Logger after called to :"
				+ joinpoint.getSignature().getName()
				+ " on " + joinpoint.getTarget().getClass());
	}
}
