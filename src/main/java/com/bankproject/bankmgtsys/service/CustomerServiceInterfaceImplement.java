package com.bankproject.bankmgtsys.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.bankproject.bankmgtsys.dao.CustomerDao;
import com.bankproject.bankmgtsys.pojo.Customer;

@Service
public class CustomerServiceInterfaceImplement implements CustomerServiceInterface {
	
	@Autowired
	private CustomerDao dao;
	
	@Override
	public boolean addCustomer(Customer customer) {
		Customer add = new Customer();
		add.setAddress(customer.getAddress());
		
		Example<Customer> customerExamp = Example.of(add);
		Optional<Customer> option = dao.findOne(customerExamp);
		if(option.isPresent()) {
			return true;
		}
		return false;
	}

}
