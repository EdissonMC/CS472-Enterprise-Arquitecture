package bank.kafka;

public class AccountTransaction {
    private long accountNumber;
    private String operation;
    private String customerName;
    private double amount;

    public AccountTransaction() {
    }

    public AccountTransaction(long accountNumber, String operation, String customerName, double amount) {
        this.accountNumber = accountNumber;
        this.operation = operation;
        this.customerName = customerName;
        this.amount = amount;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public String getOperation() {
        return operation;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "AccountInstruction{" +
                "accountNumber=" + accountNumber +
                ", action='" + operation + '\'' +
                ", customerName='" + customerName + '\'' +
                ", amount=" + amount +
                '}';
    }
}
