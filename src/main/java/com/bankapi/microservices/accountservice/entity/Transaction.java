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

@Entity
@Table(name = "Transactions")
public class Transaction extends BaseEntity<Long>{
	private static final long serialVersionUID = 1L;
	@Id
	@Access(AccessType.PROPERTY)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Access(AccessType.PROPERTY)
	@Column(name = "amount", nullable = true)
	private double amount;
	@Access(AccessType.PROPERTY)
	@Column(name = "shortDescription", nullable = true)
	private String shortDescription;
	@Access(AccessType.PROPERTY)
	@Column(name = "username", nullable = true)
	private String username;
	@Access(AccessType.PROPERTY)
	@Column(name = "occurenceDate", nullable = true)
	private Date occurenceDate;
	
	public Transaction() {super();}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getOccurenceDate() {
		return occurenceDate;
	}

	public void setOccurenceDate(Date occurenceDate) {
		this.occurenceDate = occurenceDate;
	}
}
