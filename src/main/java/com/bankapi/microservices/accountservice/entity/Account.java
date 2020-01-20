package com.bankapi.microservices.accountservice.entity;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bankapi.microservices.accountservice.entity.BaseEntity;

@Entity
@Table(name = "Accounts")
public class Account extends BaseEntity<Long>{
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public AccountStatus getStatus() {
		return status;
	}

	public void setStatus(AccountStatus status) {
		this.status = status;
	}

	public AccountType getType() {
		return type;
	}

	public void setType(AccountType type) {
		this.type = type;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	private static final long serialVersionUID = 1L;
	@Id
	@Access(AccessType.PROPERTY)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Access(AccessType.PROPERTY)
	@Column(name = "accountNumber", nullable = true)
	private String accountNumber;
	@Access(AccessType.PROPERTY)
	@Column(name = "creationDate", nullable = true)
	private Date creationDate;
	@Access(AccessType.PROPERTY)
	@Column(name = "status", nullable = true)
	private AccountStatus status;
	@Access(AccessType.PROPERTY)
	@Column(name = "type", nullable = true)
	private AccountType type;
	@Access(AccessType.PROPERTY)
	@Column(name = "username", nullable = true)
	private String username;
	
	public Account() {super();}
	
}
