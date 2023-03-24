package com.bankproject.bankmgtsys.service;

import com.bankproject.bankmgtsys.exception.AccountNumberNotFoundException;
import com.bankproject.bankmgtsys.pojo.Account;


public interface AccountServiceInterface {
	
	boolean addAccount(Account account);
	
//	List<Account> getCustomerBalance(String accountNumber)throws AccountNumberNotFoundException;
	
	Double deposit(Account cash)throws AccountNumberNotFoundException;
	
	Double withdrawable(Account cash)throws AccountNumberNotFoundException;
	
	Account totalBalance(String id)throws AccountNumberNotFoundException;

}
