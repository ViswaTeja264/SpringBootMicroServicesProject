package com.customerservice.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.customerservice.demo.beans.Customer;
import com.customerservice.demo.controllers.AddResponse;
import com.customerservice.demo.repositories.CustomerRepository;

@Component
@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRep;

	public List<Customer> fetchCustomers() {
		
		return customerRep.findAll();
		
	}
	
	public Customer fetchCustomerById(int id) {
		List<Customer> customers = customerRep.findAll();
		
		Customer customer = null;
		
		for(Customer cus : customers) {
			if(cus.getCustomerId() == id) {
				customer = cus;
			}
		}
		
		return customer;
	}
	
	public Customer fetchCustomerByName(String CustomerName) {
		List<Customer> customers = customerRep.findAll();
		
		Customer customer = null;
		
		for(Customer cus : customers) {
			if(cus.getCustomerName().equalsIgnoreCase(CustomerName)) {
				customer = cus;
			}
		}
		
		return customer;
	}
	
	public Customer addCustomer(Customer customer) {
		
		customer.setCustomerId(getMaxId());
		customerRep.save(customer);
		return customer;
		
	}

	private int getMaxId() {
		
		return customerRep.findAll().size() + 1;
		
	}
	
	public Customer updateCustomer(Customer customer) {
		
		customerRep.save(customer);
		return customer;
		
	}
	
	public AddResponse deleteCustomer(int id) {
		
		customerRep.deleteById(id);
		AddResponse res = new AddResponse();
		res.setId(id);
		res.setMsg("Customer Deleted");
		
		return res;
	}

}
