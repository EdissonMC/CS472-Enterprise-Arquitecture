package bank;

import bank.domain.Account;
import bank.domain.Customer;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AccountTest {

    private Account account;
    private Account toAccount;
    private Customer customer;
    @BeforeEach
    public void setUp() {
        account = new Account(1l);
        toAccount = new Account(2l);
        customer = new Customer("John Doe");
        account.setCustomer(customer);
    }

    @Test
    public void testAccountNumber() {
        assertThat(1l, equalTo (account.getAccountnumber()));
    }

    @Test
    public void testGetBalanceWithNoEntries() {
        assertThat(account.getBalance(), is(0.0));
    }

    @Test
    public void testIncrement(){
        Account account = new Account(1l);
        account.deposit(100.0);
        assertThat( account.getBalance(), closeTo (100.0, 0.01));
    }
    @Test
    public void testTransferFunds() {
        toAccount.setCustomer(customer);

        account.transferFunds(toAccount, 10.0, "Transfer pay");

        assertThat(account.getBalance(), is(-10.0));
        assertThat(toAccount.getBalance(), is(10.0));
    }


}
