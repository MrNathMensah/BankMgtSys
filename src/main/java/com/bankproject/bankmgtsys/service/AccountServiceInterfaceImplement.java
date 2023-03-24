package com.bankproject.bankmgtsys.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.bankproject.bankmgtsys.dao.AccountDao;
import com.bankproject.bankmgtsys.exception.AccountNumberNotFoundException;
import com.bankproject.bankmgtsys.pojo.Account;


@Service
public class AccountServiceInterfaceImplement implements AccountServiceInterface {
	
	@Autowired
	private AccountDao dao;

	@Override
	public boolean addAccount(Account account) {
			Account add = new Account();
			add.setAccountNumber(account.getAccountNumber());
			
			Example<Account> accountExamp = Example.of(add);
			Optional<Account> option = dao.findOne(accountExamp);
			if(option.isPresent()) {
				return true;
			}
			return false;
		}
	
	Double totalDeposit = 0.0;

	@Override
	public Double deposit(Account cash) {
		Account makeDeposit = new Account();
		makeDeposit.setAccountNumber(cash.getAccountNumber());
		Example<Account> accountExamp = Example.of(makeDeposit);
		Optional<Account> option = dao.findOne(accountExamp);
		totalDeposit = option.get().getBalance();
		Double newCash = cash.getBalance();
		if(option.isPresent()) {
			totalDeposit = option.get().getBalance()+ newCash;
			dao.findById(cash.getAccountNumber())
			.map(depositer->{
				depositer.setBalance(totalDeposit);
				return dao.save(depositer);
			});
			
			return totalDeposit;	
		
	}
		throw new AccountNumberNotFoundException("Account number not found");


}

	@Override
	public Double withdrawable(Account cash) {
		Account makeDeposit = new Account();
		makeDeposit.setAccountNumber(cash.getAccountNumber());
		Example<Account> accountExamp = Example.of(makeDeposit);
		Optional<Account> option = dao.findOne(accountExamp);
		totalDeposit = option.get().getBalance();
		Double newCash = cash.getBalance();
		if(option.isPresent()) {
			totalDeposit = option.get().getBalance()- newCash;
			dao.findById(cash.getAccountNumber())
			.map(depositer->{
				depositer.setBalance(totalDeposit);
				return dao.save(depositer);
			});
			
			return totalDeposit;	
		
	}
		throw new AccountNumberNotFoundException("Account number not found");
	}

	@Override
	public Account totalBalance(String id) {
			return dao.findById(id)
					.stream()
					.filter(totalBal->totalBal.getAccountNumber().equals(id))
					.findAny()
					.orElseThrow(()-> new AccountNumberNotFoundException("Account Number not found"));
	}


	
}

