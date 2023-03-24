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
public class Bank {
	
	@Id
	@GeneratedValue
	private Integer bankcode;
	
	private String bankname;
	
	@Embedded
	private Address address;
	
	@OneToMany(mappedBy="bank")
	private List<Branch> branch;
	


}
