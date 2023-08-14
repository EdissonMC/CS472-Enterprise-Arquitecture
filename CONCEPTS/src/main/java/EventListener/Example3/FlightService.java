package EventListener.Example3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class FlightService {

    @Autowired
    private ApplicationEventPublisher publisher;
    public void purchaseFlight(){
        publisher.publishEvent(new FlightEvent(this));
    }
}
