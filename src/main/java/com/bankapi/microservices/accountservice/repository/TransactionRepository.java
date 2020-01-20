package com.bankapi.microservices.accountservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.bankapi.microservices.accountservice.entity.Account;
import com.bankapi.microservices.accountservice.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction,Long>{
	
	@Transactional(readOnly = true)
	List<Transaction> findByUsernameOrderByOccurenceDateDesc(String username);
}
