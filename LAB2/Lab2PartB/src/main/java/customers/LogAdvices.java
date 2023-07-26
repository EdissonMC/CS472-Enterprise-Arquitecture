package customers;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Aspect
//@Component
@Configuration
public class LogAdvices {


//    @Before("execution(* customers.Logger.log(String))")
//    public void beforeLog(){
//        System.out.println("Before LOG");
//    }

//    @After("execution(public void log())")
//    @After("execution(* EmailSender.sendEmail(String, String))")
//    @After("execution(* EmailSender.sendEmail(..))")
    @After("execution(* EmailSender.sendEmail(..)) && args(email, message)")
    public void afterLog(JoinPoint joinpoint, String email, String message){
//        System.out.println("AFTER LOG");


        System.out.println(new Date() + " method= "
                + joinpoint.getSignature().getName() + " email address= "
                + email + " message= " + message);
        IEmailSender emailSender = (IEmailSender) joinpoint.getTarget();

        System.out.println("outgoing mail server = "+emailSender.getOutgoingMailServer());
    }

}
