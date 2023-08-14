package bank.service;

import bank.domain.Account;
import bank.domain.AccountEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class AccountAdapter {
    private static Logger logger = LoggerFactory.getLogger(AccountAdapter.class);

    public static Account getAccountFromAccountDTO(AccountDTO accountDto){
        logger.trace("-> Get into getAccountFromAccountDTO");
        Account account = new Account();
        account.setAccountnumber(accountDto.getAccountnumber());
        account.setCustomer(CustomerAdapter.getCustomerFromCustomerDTO(accountDto.getCustomer()));
        for (AccountEntryDTO accountEntryDto : accountDto.getEntryList()){
            account.getEntryList().add(AccountEntryAdapter.getAccountEntryFromAccountEntryDTO(accountEntryDto));
        }
        return account;
    }

    public static AccountDTO getAccountDTOFromAccount(Account account){
        logger.trace("-> Get into getAccountDTOFromAccount");
        AccountDTO accountDto = new AccountDTO();
        accountDto.setAccountnumber(account.getAccountnumber());
        accountDto.setBalance(account.getBalance());
        accountDto.setCustomer(CustomerAdapter.getCustomerDTOFromCustomer(account.getCustomer()));
        for (AccountEntry accountEntry : account.getEntryList()){
            accountDto.getEntryList().add(AccountEntryAdapter.getAccountEntryDTOFromAccountEntry(accountEntry));
        }
        return accountDto;
    }

    public static List<AccountDTO> getAccountDTOListFromAccountList(List<Account> accountList){
        logger.trace("-> Get into getAccountDTOListFromAccountList");
        List<AccountDTO> accountDTOList = new ArrayList<AccountDTO>();
        for (Account account : accountList){
            accountDTOList.add(getAccountDTOFromAccount(account));
        }
        return accountDTOList;
    }
}
