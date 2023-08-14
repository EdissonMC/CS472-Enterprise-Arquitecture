package EventListener.Example3;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;

public class FlightEvent extends ApplicationEvent {

    public FlightEvent(Object source){
        super(source);

    }

}
