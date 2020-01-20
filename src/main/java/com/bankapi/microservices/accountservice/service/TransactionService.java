package com.bankapi.microservices.accountservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapi.microservices.accountservice.entity.Transaction;
import com.bankapi.microservices.accountservice.repository.TransactionRepository;

@Service
public class TransactionService {
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Transactional(readOnly = true)
	public List<Transaction> listTransactionsByUsername(String userName){
		return transactionRepository.findByUsernameOrderByOccurenceDateDesc(userName);	
	}
}
