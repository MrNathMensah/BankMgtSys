package com.bankproject.bankmgtsys.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
public class Loan {
	
	@Id
	@GeneratedValue
	private Integer loadId;
	
	private Double amount;
	private String loanType;
	
	@ManyToOne
	@JoinColumn(name="Branch_Id")
	private Branch branch;
	
	@ManyToOne
	@JoinColumn(name="Customer_Id")
	private Customer customer;
	

}
