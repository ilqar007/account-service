package com.bankapi.microservices.accountservice.dto;

import com.bankapi.microservices.accountservice.entity.AccountType;

public class AccountRequestDto {
private AccountType accountType;
private String username;
public AccountType getAccountType() {
	return accountType;
}
public void setAccountType(AccountType accountType) {
	this.accountType = accountType;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}

}
