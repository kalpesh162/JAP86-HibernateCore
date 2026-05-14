package com.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "emp")
public class Employee {

	
	@Embedded
	private Address address;
}
