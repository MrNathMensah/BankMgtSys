package com.bankproject.bankmgtsys.pojo;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Address {
	
	private String streetName;
	private String digitalAddress;
	private String email;
	private String phoneOne;
	private String phoneTwo;
	
	

}
