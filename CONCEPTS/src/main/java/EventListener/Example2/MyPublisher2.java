package EventListener.Example2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;


@Component
public class MyPublisher2 {

    @Autowired
    ApplicationEventPublisher publisher;

    @Async
    public void emiteEvent(String message){
        publisher.publishEvent(new MyEvent2 (this,"hello world 2"));
    }

}
