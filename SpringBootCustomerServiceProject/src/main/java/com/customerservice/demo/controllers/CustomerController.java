package com.customerservice.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.customerservice.demo.beans.Customer;
import com.customerservice.demo.services.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> fetchCustomers() {
		
		try {
			List<Customer> customers = customerService.fetchCustomers();
			return new ResponseEntity<List<Customer>>(customers, HttpStatus.FOUND);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
	}
	
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> fetchCustomerById(@PathVariable int id) {
		
		try {
			Customer customer = customerService.fetchCustomerById(id);
			return new ResponseEntity<Customer>(customer, HttpStatus.FOUND);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping("/customers/customername")
	public ResponseEntity<Customer> fetchCustomerByName(@RequestParam(value="name") String name) {
		
		try {
			Customer customer = customerService.fetchCustomerByName(name);
			return new ResponseEntity<Customer>(customer, HttpStatus.FOUND);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping("/addcustomer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		
		try {
			Customer newCustomer = customerService.addCustomer(customer);
			return new ResponseEntity<Customer>(newCustomer, HttpStatus.CREATED);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
	}
	
	@PutMapping("/updatecustomer/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable(value="id") int id, @RequestBody Customer customer) {
		
		try {
			Customer ExistedCustomer = customerService.fetchCustomerById(id);
			ExistedCustomer.setCustomerName(customer.getCustomerName());
			ExistedCustomer.setCustomerAge(customer.getCustomerAge());
			ExistedCustomer.setCustomerDOB(customer.getCustomerDOB());
			ExistedCustomer.setProfession(customer.getProfession());
			
			Customer UpdatedCustomer = customerService.updateCustomer(ExistedCustomer);
			return new ResponseEntity<Customer>(UpdatedCustomer, HttpStatus.OK);
			
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
	}
	
	@DeleteMapping("/deletecustomer/{id}")
	public  ResponseEntity<AddResponse> deleteCustomer(@PathVariable(value="id") int id) {
		
		try {
			AddResponse response = customerService.deleteCustomer(id);
			return new ResponseEntity<AddResponse>(response, HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
	}
	
}
