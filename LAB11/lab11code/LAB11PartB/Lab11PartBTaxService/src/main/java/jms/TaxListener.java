package jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class TaxListener {


    @JmsListener(destination = "taxQueue")
    public void listener(String message) {
        System.out.println("Message Received : " + message);
    }
}
