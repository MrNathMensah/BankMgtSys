package com.bankproject.bankmgtsys.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankproject.bankmgtsys.pojo.Branch;

public interface BranchDao extends JpaRepository<Branch, Integer> {

}
