package com.pro.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.Dao.CustomerDao;
import com.pro.Exception.AuthenticationException;
import com.pro.Exception.ResourceNotFoundException;
import com.pro.dto.AuthRequest;
import com.pro.dto.AuthResponse;
import com.pro.pojos.Customer;
import com.pro.pojos.User;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerServImpl implements CustomerServ {
	
	@Autowired
	private CustomerDao cDao;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public String AddCustomer(Customer cust) {
		Customer cs=cDao.save(cust);
		return "Added Customer!!"+cs;
	}

	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> cp=cDao.findAll();
		return cp;
	}

	@Override
	public String DeleteCustomer(Long Id) {
		if(cDao.existsById(Id))
		{
			cDao.deleteById(Id);
			return "Deleted succesfully!!";
		}
		throw new ResourceNotFoundException("Invalid Id!! ");
	}

	@Override
	public String UpdateCustomer(Long Id, Customer cop) {
		if(cDao.existsById(Id))
		{
			Customer cp=cDao.save(cop);
			return "Updated Details!!"+cp;
		}
		throw new ResourceNotFoundException("Invalid Id!! ");
	}

	@Override
	public Customer getCustomerById(Long id) {

		return cDao.findById(id).orElseThrow(()->new ResourceNotFoundException("Invalid Id!"));
		
	}

	@Override
	public AuthResponse authenticateUser(AuthRequest request) {
		Customer entity=cDao.findByEmailAndPassword(request.getEmail(), request.getPassword())
				.orElseThrow(()->new AuthenticationException("Invalid email or password"));
		return mapper.map(entity,AuthResponse.class);
	}

}
