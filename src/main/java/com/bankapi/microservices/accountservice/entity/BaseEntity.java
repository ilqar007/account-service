package com.bankapi.microservices.accountservice.entity;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity<T extends Serializable> implements Serializable {

	private static final long serialVersionUID = 1L;
	

}