package com.customerservice.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customerservice.demo.beans.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
	

}
