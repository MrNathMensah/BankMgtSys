package com.bankproject.bankmgtsys.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankproject.bankmgtsys.pojo.Bank;

public interface BankDao extends JpaRepository<Bank, Integer> {

}
