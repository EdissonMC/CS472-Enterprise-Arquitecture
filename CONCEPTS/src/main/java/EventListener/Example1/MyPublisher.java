package EventListener.Example1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class MyPublisher {

    @Autowired
    ApplicationEventPublisher publisher ;

    public void puublishEventGo(String message){
        MyEvent myEvent= new MyEvent(this, message);

        publisher.publishEvent(myEvent);

    }
}
