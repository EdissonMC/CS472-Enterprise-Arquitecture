package bank.service;

import bank.domain.Account;

import java.util.ArrayList;
import java.util.Collection;

public class AccountsDTO {

    Collection<AccountDTO> accountList = new ArrayList<AccountDTO>();

    public Collection<AccountDTO> getAccountList() {
        return accountList;
    }

    public void setAccountList(Collection<AccountDTO> accountList) {
        this.accountList = accountList;
    }
}
