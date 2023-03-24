package com.bankproject.bankmgtsys.pojo;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Customer {
	
	@Id
	@GeneratedValue
	private Integer customerId;
	
	private String name;
	
	@Embedded
	private Address address;
	
	@OneToMany(mappedBy="customer")
	private List<Loan> loan;
	
	@OneToMany(mappedBy="account")
	private List<Account> account;
	
	

}
