package bank.service;

import java.util.Collection;
import java.util.List;

import bank.dao.IAccountDAO;
import bank.domain.Account;
import bank.domain.Customer;
import bank.events.AuditEvent;
import bank.jms.IJMSSender;
import bank.logging.ILogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class AccountService implements IAccountService {
    @Autowired
    private IAccountDAO accountDAO;
    @Autowired
    private ICurrencyConverter currencyConverter;
    @Autowired
    private IJMSSender jmsSender;
    @Autowired
    private ILogger logger;


    @Autowired
    ApplicationEventPublisher publisher;

    public AccountDTO createAccount(long accountNumber, String customerName) {
        Account account = new Account(accountNumber);
        Customer customer = new Customer(customerName);
        account.setCustomer(customer);
        accountDAO.save(account);

        publisher.publishEvent(new AuditEvent(this,account.getCustomer().getName(), accountNumber, "Create", 0.0));

        logger.log("createAccount with parameters accountNumber= "
                + accountNumber + " , customerName= " + customerName);
        return AccountAdapter.getAccountDTOFromAccount(account);
    }


    public void deposit(long accountNumber, double amount) {
        Account account = accountDAO.findById(accountNumber).get();
        account.deposit(amount);
        accountDAO.save(account);
        logger.log("deposit with parameters accountNumber= " + accountNumber
                + " , amount= " + amount);

        publisher.publishEvent(new AuditEvent(this,account.getCustomer().getName() ,accountNumber, "deposit", amount));


        if (amount > 10000) {
            jmsSender.sendJMSMessage("Deposit of $ " + amount
                    + " to account with accountNumber= " + accountNumber);
        }
    }


    public AccountDTO getAccount(long accountNumber) {
        Account account = accountDAO.findById(accountNumber).get();
        return AccountAdapter.getAccountDTOFromAccount(account);
    }


    public Collection<AccountDTO> getAllAccounts() {
        List<Account> accountList = accountDAO.findAll();
        return AccountAdapter.getAccountDTOListFromAccountList(accountList);
    }


    public void withdraw(long accountNumber, double amount) {
        Account account = accountDAO.findById(accountNumber).get();
        account.withdraw(amount);
        accountDAO.save(account);

        publisher.publishEvent(new AuditEvent(this, account.getCustomer().getName(),accountNumber, "withdraw", amount));


        logger.log("withdraw with parameters accountNumber= " + accountNumber
                + " , amount= " + amount);
    }


    public void depositEuros(long accountNumber, double amount) {
        Account account = accountDAO.findById(accountNumber).get();
        double amountDollars = currencyConverter.euroToDollars(amount);
        account.deposit(amountDollars);
        accountDAO.save(account);
        logger.log("depositEuros with parameters accountNumber= "
                + accountNumber + " , amount= " + amount);


        publisher.publishEvent(new AuditEvent(this, account.getCustomer().getName(), accountNumber, "depositEuros", amount));


        if (amountDollars > 10000) {
            jmsSender.sendJMSMessage("Deposit of $ " + amount
                    + " to account with accountNumber= " + accountNumber);
        }
    }


    public void withdrawEuros(long accountNumber, double amount) {
        Account account = accountDAO.findById(accountNumber).get();
        double amountDollars = currencyConverter.euroToDollars(amount);
        account.withdraw(amountDollars);
        accountDAO.save(account);


        publisher.publishEvent(new AuditEvent(this,account.getCustomer().getName(),accountNumber ,"withdrawEuros", amount));

        logger.log("withdrawEuros with parameters accountNumber= "
                + accountNumber + " , amount= " + amount);
    }

    public void transferFunds(long fromAccountNumber, long toAccountNumber,
                              double amount, String description) {
        Account fromAccount = accountDAO.findById(fromAccountNumber).get();
        Account toAccount = accountDAO.findById(toAccountNumber).get();
        fromAccount.transferFunds(toAccount, amount, description);
        accountDAO.save(fromAccount);
        accountDAO.save(toAccount);


        logger.log("transferFunds with parameters fromAccountNumber= "
                + fromAccountNumber + " , toAccountNumber= " + toAccountNumber
                + " , amount= " + amount + " , description= " + description);
        if (amount > 10000) {
            jmsSender.sendJMSMessage("TransferFunds of $ " + amount
                    + " from account with accountNumber= " + fromAccount
                    + " to account with accountNumber= " + toAccount);
        }
    }
}
