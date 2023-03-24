package com.bankproject.bankmgtsys.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankproject.bankmgtsys.pojo.Loan;

public interface LoanDao extends JpaRepository<Loan, Integer> {

}
