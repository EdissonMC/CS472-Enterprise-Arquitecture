package bank.timers;


import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TaskTimer {

    private int count = 0;

//    @Scheduled(fixedRate = 5000)
    @Scheduled(cron = "*/3 * * * * *")
    public void increment() throws InterruptedException {
        Thread.sleep(3000); // 30 seconds
        count = count + 1;
        System.out.println("counting "+ count);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now = new Date();
        String strDate = sdf.format(now);
        System.out.println("Java cron job expression:: " + strDate);
    }

    public int getCount() {
        return count;
    }
}


//
//@Service
//public class AccountService{
//    private int count=0;
//
//    public void deposit(long account){
//        count = count+1;
//        //code for the deposite
//    }
//
//    public int getCount(){
//        return count;
//    }
//
//}



//
//@RestController
//@CrossOrigin
//public class Controller {
//    Integer counter= 0;
//    @GetMapping("/books/{isbn}")
//    public ResponseEntity<?> getCount(@PathVariable String isbn) {
//
//        counter++;
//        System.out.println("REQUEST " + counter);
//
//
//        return new ResponseEntity<String>("ok", HttpStatus.OK);
//    }
//}




//
//@Component
//@EnableJms
//public class CounterMessages {
//
//    private int count=0;
//
//    @JmsListener(destination = "testQueue")
//    public synchronized void process(String data) {
//
//       count=count+1;
//    }
//
//    public getCount(){
//        return count;
//    }
//
//}


//
//@Component
//public class SheduledCounter {
//
//    private int count=0;
//
//    @Sheduled(cron = "*/10*****")
//    public  void increment() throws  InterruptedException {
//        Thread.sleep(30000);//30 seconds
//        count=count+1;
//    }
//
//    public getCount(){
//        return count;
//    }
//
//}
//
//@Component
//@EnableAsync
//public class DepositEventListener{
//    private int count=0;
//
//    @EventListener
//    @Async
//    public void onEvent(DepositEvent event){
//        count=count+1;
//    }
//
//    public int getCount(){
//        return count;
//    }
//
//}



//
//@RestController
//@CrossOrigin
//public class Controller {
//    Integer counter= 0;
//    @GetMapping("/books/{isbn}")
//    public ResponseEntity<?> getCount(@PathVariable String isbn) {
//
//        counter++;
//        System.out.println("REQUEST " + counter);
//
//
//        return new ResponseEntity<String>("ok", HttpStatus.OK);
//    }
//}



