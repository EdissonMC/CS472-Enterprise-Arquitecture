package bank.service;

import java.util.Collection;

import bank.aspect.DaoLogAspect;
import bank.dao.AccountDAO;
import bank.dao.IAccountDAO;
import bank.domain.Account;
import bank.domain.Customer;
import bank.jms.IJMSSender;
import bank.jms.JMSSender;
import bank.logging.ILogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {

//	private IAccountDAO accountDAO;
//	private ICurrencyConverter currencyConverter;
//	private IJMSSender jmsSender;
//	private ILogger logger;


	@Autowired
	private IAccountDAO accountDAO;
	@Autowired
	private ICurrencyConverter currencyConverter;
	@Autowired
	private IJMSSender jmsSender;
//	@Autowired
//	private ILogger logger;
	private Logger logger = LoggerFactory.getLogger(AccountService.class);


//	public AccountService(){
//		accountDAO=new AccountDAO();
//		currencyConverter= new CurrencyConverter();
//		jmsSender =  new JMSSender();
//		logger = new Logger();
//	}

	public Account createAccount(long accountNumber, String customerName) {
		Account account = new Account(accountNumber);
		Customer customer = new Customer(customerName);
		account.setCustomer(customer);
		accountDAO.saveAccount(account);
		logger.trace("createAccount with parameters accountNumber= "+accountNumber+" , customerName= "+customerName);
		return account;
	}

	public void deposit(long accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		account.deposit(amount);
		accountDAO.updateAccount(account);
		logger.trace("deposit with parameters accountNumber= "+accountNumber+" , amount= "+amount);
		if (amount > 10000){
			jmsSender.sendJMSMessage("Deposit of $ "+amount+" to account with accountNumber= "+accountNumber);
		}
	}

	public Account getAccount(long accountNumber) {
		Account account = accountDAO.loadAccount(accountNumber);
		return account;
	}

	public Collection<Account> getAllAccounts() {
		return accountDAO.getAccounts();
	}

	public void withdraw(long accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		account.withdraw(amount);
		accountDAO.updateAccount(account);
		logger.trace("withdraw with parameters accountNumber= "+accountNumber+" , amount= "+amount);
	}

	public void depositEuros(long accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		double amountDollars = currencyConverter.euroToDollars(amount);
		account.deposit(amountDollars);
		accountDAO.updateAccount(account);
		logger.trace("depositEuros with parameters accountNumber= "+accountNumber+" , amount= "+amount);
		if (amountDollars > 10000){
			jmsSender.sendJMSMessage("Deposit of $ "+amount+" to account with accountNumber= "+accountNumber);
		}
	}

	public void withdrawEuros(long accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		double amountDollars = currencyConverter.euroToDollars(amount);
		account.withdraw(amountDollars);
		accountDAO.updateAccount(account);
		logger.trace("withdrawEuros with parameters accountNumber= "+accountNumber+" , amount= "+amount);
	}

	public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
		Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
		Account toAccount = accountDAO.loadAccount(toAccountNumber);
		fromAccount.transferFunds(toAccount, amount, description);
		accountDAO.updateAccount(fromAccount);
		accountDAO.updateAccount(toAccount);
		logger.trace("transferFunds with parameters fromAccountNumber= "+fromAccountNumber+" , toAccountNumber= "+toAccountNumber+" , amount= "+amount+" , description= "+description);
		if (amount > 10000){
			jmsSender.sendJMSMessage("TransferFunds of $ "+amount+" from account with accountNumber= "+fromAccount+" to account with accountNumber= "+toAccount);
		}
	}

//	public IAccountDAO getAccountDAO() {
//		return accountDAO;
//	}
//
//	@Autowired
//	public void setAccountDAO(IAccountDAO accountDAO) {
//		this.accountDAO = accountDAO;
//	}
//
//	public ICurrencyConverter getCurrencyConverter() {
//		return currencyConverter;
//	}
//
//	@Autowired
//	public void setCurrencyConverter(ICurrencyConverter currencyConverter) {
//		this.currencyConverter = currencyConverter;
//	}
//
//	public IJMSSender getJmsSender() {
//		return jmsSender;
//	}
//
//	@Autowired
//	public void setJmsSender(IJMSSender jmsSender) {
//		this.jmsSender = jmsSender;
//	}
//
//	public ILogger getLogger() {
//		return logger;
//	}
//
//	@Autowired
//	public void setLogger(ILogger logger) {
//		this.logger = logger;
//	}

}
