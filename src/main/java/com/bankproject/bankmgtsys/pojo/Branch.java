package com.bankproject.bankmgtsys.pojo;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Branch {
	
	@Id
	@GeneratedValue
	private Integer branchId;
	
	private String branchName;
	
	@Embedded
	private Address address;
	
	@ManyToOne
	@JoinColumn(name="code")
	private Bank bank;
	
	@OneToMany(mappedBy="branch")
	private List<Loan> loan;
	
	@OneToMany(mappedBy="account")
	private List<Account> account;


}
