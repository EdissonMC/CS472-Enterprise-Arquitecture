package bank.domain;

import java.util.ArrayList;
import java.util.Collection;

public class Accounts {

    Collection<Account> accountList = new ArrayList<Account>();

    public Collection<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(Collection<Account> accountList) {
        this.accountList = accountList;
    }
}
