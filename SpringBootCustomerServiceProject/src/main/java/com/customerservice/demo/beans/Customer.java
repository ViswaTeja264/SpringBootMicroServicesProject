package com.customerservice.demo.beans;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Customer")
public class Customer {
	
	@Id
	@Column(name="customer_id")
	private int CustomerId;
	
	@Column(name="customer_name")
	private String CustomerName;
	
	@Column(name="customer_age")
	private int CustomerAge;
	
	@Column(name="customer_dob")
	private Date CustomerDOB;
	
	@Column(name="profession")
	private String Profession;
	
	
	public Customer() {
		
	}
	
	
	public Customer(int CustomerId, String CustomerName, int CustomerAge, Date CustomerDOB, String Profession) {
		
		super();
		this.CustomerId = CustomerId;
		this.CustomerName = CustomerName;
		this.CustomerAge = CustomerAge;
		this.CustomerDOB = CustomerDOB;
		this.Profession = Profession;
		
	}
	

	public int getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(int customerId) {
		CustomerId = customerId;
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}

	public int getCustomerAge() {
		return CustomerAge;
	}

	public void setCustomerAge(int customerAge) {
		CustomerAge = customerAge;
	}

	public Date getCustomerDOB() {
		return CustomerDOB;
	}

	public void setCustomerDOB(Date customerDOB) {
		CustomerDOB = customerDOB;
	}

	public String getProfession() {
		return Profession;
	}

	public void setProfession(String profession) {
		Profession = profession;
	}
	
	

}
