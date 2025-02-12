package com.pro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pro.dto.ApiResponse;
import com.pro.dto.AuthRequest;
import com.pro.dto.AuthResponse;
import com.pro.pojos.Customer;
import com.pro.service.CustomerServ;



@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerServ cServ;
	
	@PostMapping
	public ResponseEntity<?> addCustomer(@RequestBody Customer cus) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(cServ.AddCustomer(cus)));
	}
	
	@GetMapping
	public ResponseEntity<?> getAllCustomer() {
		List<Customer>cop=cServ.getAllCustomer();
		if(cop.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.ok(cop);
	}
	
	@DeleteMapping("/{cid}")
	ResponseEntity<?> DeleteCustId(@PathVariable Long cid)
	{
		try {
			return ResponseEntity.ok(new ApiResponse(cServ.DeleteCustomer(cid)));
			}
		catch(RuntimeException excep)
		{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(excep.getMessage()));
		}
	}
	
	@PutMapping("/{cid}")
	ResponseEntity<?> UpdateCustomer(@PathVariable Long cid,@RequestBody Customer co)
	{
		return ResponseEntity.ok(new ApiResponse(cServ.UpdateCustomer(cid, co)));
	}
	
	@GetMapping("/{cid}")
	public ResponseEntity<?> getMethodName(@PathVariable Long cid) {
	
		return ResponseEntity.ok(cServ.getCustomerById(cid));
	}
	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@RequestBody AuthRequest dto){
		try {
			AuthResponse respDto=cServ.authenticateUser(dto);
			return ResponseEntity.ok(respDto);
		}catch(RuntimeException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ApiResponse(e.getMessage()));
		}
	}
	
	
}
