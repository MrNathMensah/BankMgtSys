package com.bankproject.bankmgtsys.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankproject.bankmgtsys.pojo.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer> {

}
