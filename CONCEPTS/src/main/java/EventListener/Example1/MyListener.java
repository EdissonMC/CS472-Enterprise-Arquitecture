package EventListener.Example1;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyListener {

    @EventListener
    public void handlerMyEvent(MyEvent event){
        System.out.println("-> I get the Event :)  " + event.getMessage());
    }
}
