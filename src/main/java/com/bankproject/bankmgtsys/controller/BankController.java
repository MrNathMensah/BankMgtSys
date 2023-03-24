package com.bankproject.bankmgtsys.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankController {
	
	@GetMapping("/welcom")
	public String getInfo() {
		return "My Project is messing up";
	}
}
