package com.bankproject.bankmgtsys.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankproject.bankmgtsys.pojo.Account;

public interface AccountDao extends JpaRepository<Account, String> {


}
