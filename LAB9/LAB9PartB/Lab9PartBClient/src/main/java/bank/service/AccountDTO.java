package bank.service;

import bank.domain.AccountEntry;
import bank.domain.Customer;

import java.util.ArrayList;
import java.util.Collection;

public class AccountDTO {
    long accountnumber;

    Collection<AccountEntry> entryList = new ArrayList<AccountEntry>();
    Customer customer;

    public AccountDTO( ) {

    }

    public long getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(long accountnumber) {
        this.accountnumber = accountnumber;
    }

    public Collection<AccountEntry> getEntryList() {
        return entryList;
    }

    public void setEntryList(Collection<AccountEntry> entryList) {
        this.entryList = entryList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
