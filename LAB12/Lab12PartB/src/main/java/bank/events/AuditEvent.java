package bank.events;

import org.springframework.context.ApplicationEvent;

public class AuditEvent extends ApplicationEvent {

    private String Customer;
    private Long AccountNumber;
    private String operation;
    private Double amount;




    public AuditEvent(Object source, String customer, Long accountNumber, String operation, Double amount) {
        super(source);
        Customer = customer;
        AccountNumber = accountNumber;
        this.operation = operation;
        this.amount = amount;
    }

    public Long getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        AccountNumber = accountNumber;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCustomer() {
        return Customer;
    }

    public void setCustomer(String customer) {
        Customer = customer;
    }
}
