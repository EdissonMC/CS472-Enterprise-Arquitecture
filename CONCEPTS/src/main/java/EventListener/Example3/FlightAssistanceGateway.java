package EventListener.Example3;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;


@Component
public class FlightAssistanceGateway   {

    @EventListener
    @Async
    public void addFlighPurchase(FlightEvent event ){
        System.out.println("-> Notified: addFlighPurchase");
    }

}
