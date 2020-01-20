package com.bankapi.microservices.accountservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.bankapi.microservices.accountservice.entity.Account;
import com.bankapi.microservices.accountservice.entity.AccountStatus;

public interface AccountRepository  extends JpaRepository<Account,Long>{

	@Transactional(readOnly = true)
	List<Account> findByUsernameAndStatus(String username,AccountStatus status);
}
