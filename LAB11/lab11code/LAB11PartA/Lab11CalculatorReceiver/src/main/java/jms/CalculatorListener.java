package jms;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class CalculatorListener {

    Calculator cal = new Calculator();

    @JmsListener(destination = "testQueue")
    public synchronized void process(String data) {

        ObjectMapper mapper = new ObjectMapper();

        try {
            CalculatorMessage dataReceived = mapper.readValue(data, CalculatorMessage.class);
            System.out.println("-> OPERATION RECEIVED");

            if (dataReceived.getOperator().equals("+")) {
                cal.add(dataReceived.getValue());
                System.out.println("-> + ");
            } else if (dataReceived.getOperator().equals("-")) {
                cal.subtract(dataReceived.getValue());
                System.out.println("-> - ");
            }
            System.out.println("-> OPERATION APPLIED");

        } catch (Exception e) {
            System.out.println("ERROR TRYING TO CONVERT" + data + " TO AN OBJECT");
        }
    }


}


