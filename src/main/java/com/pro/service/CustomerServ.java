package com.pro.service;

import java.util.List;

import com.pro.dto.AuthRequest;
import com.pro.dto.AuthResponse;
import com.pro.pojos.Customer;

public interface CustomerServ {
	
	String AddCustomer(Customer cust);
	
	List<Customer>getAllCustomer();
	
	String DeleteCustomer(Long Id);
	
	String UpdateCustomer(Long Id,Customer cop);
	
	Customer getCustomerById(Long id);
	
	AuthResponse authenticateUser(AuthRequest request);
}
