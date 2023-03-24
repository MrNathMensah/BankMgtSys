package com.bankproject.bankmgtsys.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Account {
	
	@Id
	private String accountNumber;
	
	private String accountType;
	private Double balance;
	
	@ManyToOne
	@JoinColumn(name="Branch_Id")
	private Account account;
	
	@ManyToOne
	@JoinColumn(name="Customer_Id")
	private Customer customer;
	

}
