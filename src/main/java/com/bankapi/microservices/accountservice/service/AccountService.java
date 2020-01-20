package com.bankapi.microservices.accountservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapi.microservices.accountservice.entity.Account;
import com.bankapi.microservices.accountservice.entity.AccountStatus;
import com.bankapi.microservices.accountservice.repository.AccountRepository;

@Service
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;
	
	@Transactional(readOnly = true)
	public void Save(Account account) {
		accountRepository.saveAndFlush(account);
	}
	
	@Transactional(readOnly = true)
	public List<Account> listAccountsByUserName(String userName){
		return accountRepository.findByUsernameAndStatus(userName,AccountStatus.Active);	
	}
	@Transactional(readOnly = true)
	public Account findAccountById(Long id){
		return accountRepository.findById(id).get();	
	}
}
