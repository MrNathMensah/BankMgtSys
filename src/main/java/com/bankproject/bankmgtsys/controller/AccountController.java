package com.bankproject.bankmgtsys.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankproject.bankmgtsys.dao.AccountDao;
import com.bankproject.bankmgtsys.pojo.Account;
import com.bankproject.bankmgtsys.service.AccountServiceInterfaceImplement;

@RestController
public class AccountController {
	
	@Autowired
	private AccountDao dao;
	
	@Autowired
	private AccountServiceInterfaceImplement service;
	
	@PostMapping("/saveaccount")
	public ResponseEntity<?> addAccount(@RequestBody Account account){
		
		boolean serviceAccount = service.addAccount(account);
		HttpHeaders header = new HttpHeaders();
		header.add("desc", "this is to add account");
		if(!serviceAccount) {
			dao.save(account);
			return ResponseEntity.ok("Account is saved successfully");
		}
		
		return new ResponseEntity<String>("Customer with this Account Number already exist", HttpStatus.OK);
	}
	
	@PostMapping("/deposit")
	public Double depositCash(@RequestBody Account cashdep){
		Double depositAmt = service.deposit(cashdep);
		return depositAmt;
	}
	
	@PostMapping("/withdraw")
	public Double getWithdrawalBalance(@RequestBody Account cash){
		Double withdrawAmt = service.withdrawable(cash);
		return withdrawAmt;
	}
	
	@GetMapping("/depositBalance/{account}")
	public ResponseEntity<?> getTotalPayment(@PathVariable String account){
		Account totalAmount = service.totalBalance(account);
		return ResponseEntity.status(HttpStatus.OK).body("This is your total balance: " + totalAmount.getBalance());
	}
	
}

