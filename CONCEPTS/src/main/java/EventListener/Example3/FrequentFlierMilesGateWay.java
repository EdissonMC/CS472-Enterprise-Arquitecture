package EventListener.Example3;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class FrequentFlierMilesGateWay {

    @EventListener
    @Async
    public void addMiles(FlightEvent event){
        System.out.println("-> Notified: addMiles");
    }


}
