package com.bankproject.bankmgtsys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankproject.bankmgtsys.dao.CustomerDao;
import com.bankproject.bankmgtsys.pojo.Customer;
import com.bankproject.bankmgtsys.service.CustomerServiceInterfaceImplement;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerDao dao;
	
	@Autowired
	private CustomerServiceInterfaceImplement service;
	
	@PostMapping("/savecustomer")
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer){
		
		boolean serviceCustomer = service.addCustomer(customer);
		HttpHeaders header = new HttpHeaders();
		header.add("desc", "this is to add customer");
		if(!serviceCustomer) {
			dao.save(customer);
			return ResponseEntity.ok("Customer is saved successfully");
		}
		
		return new ResponseEntity<String>("Customer with this address already exist", HttpStatus.OK);
	}

}
