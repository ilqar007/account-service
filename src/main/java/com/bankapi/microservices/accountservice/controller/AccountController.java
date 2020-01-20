package com.bankapi.microservices.accountservice.controller;


import java.util.Date;
import java.util.List;
import java.util.Random;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bankapi.microservices.accountservice.dto.AccountRequestDto;
import com.bankapi.microservices.accountservice.entity.Account;
import com.bankapi.microservices.accountservice.entity.AccountStatus;
import com.bankapi.microservices.accountservice.entity.Transaction;
import com.bankapi.microservices.accountservice.service.AccountService;
import com.bankapi.microservices.accountservice.service.TransactionService;

@RestController
@RequestMapping(path = "/account")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping(value = "openAccount")
    public ResponseEntity<String> openAccount(@RequestBody AccountRequestDto accountDto) {
		Account account = new Account();
		account.setUsername(accountDto.getUsername());
		account.setType(accountDto.getAccountType());
		account.setCreationDate(new Date());
		account.setStatus(AccountStatus.Active);
		String accountNumber = "AccountNumber_"+Math.abs(new Random().nextInt());
		account.setAccountNumber(accountNumber);
		accountService.Save(account);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
	
	@RequestMapping(path = "/listAccountsByUsername/{username}", method = RequestMethod.GET)
	public ResponseEntity<List<Account>> listAccountsByUsername(@PathVariable String username) {
		List<Account> accounts=	accountService.listAccountsByUserName(username);
		return new ResponseEntity<List<Account>>(accounts, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/findAccountById/{id}", method = RequestMethod.GET)
	public ResponseEntity<Account> findAccountById(@PathVariable Long id) {
		Account account=	accountService.findAccountById(id);
		return new ResponseEntity<Account>(account, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/listTransactionsByUsername/{username}", method = RequestMethod.GET)
	public ResponseEntity<List<Transaction>> listTransactionsByUsername(@PathVariable String username) {
		List<Transaction> tranactions=	transactionService.listTransactionsByUsername(username);
		return new ResponseEntity<List<Transaction>>(tranactions, HttpStatus.OK);
	}
}
