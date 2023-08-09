package bank.events;


import bank.dao.TraceDataDAO;
import bank.domain.TraceData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class ManagerEvents {

    @Autowired
    private TraceDataDAO traceDataDAO;

    @EventListener
    @Async
    public void sendEmail(AuditEvent event) {
        System.out.println("-> -> Sending email to " + event.getCustomer() + ", Because next transaction: " + event.getOperation());
    }


    @EventListener
    @Async
    public void traceRecord(AuditEvent event) {

        TraceData traceData = new TraceData(event.getAccountNumber(), event.getOperation(), event.getAmount());
        traceDataDAO.save(traceData);
        System.out.println("-> -> Tracking record, Because : " + event.getOperation());
    }
}
