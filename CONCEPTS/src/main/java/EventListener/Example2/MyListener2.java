package EventListener.Example2;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MyListener2{

    @EventListener
    @Async
    public void myListener(MyEvent2 event2){
        System.out.println("I am listening the event#2");
    }

}
