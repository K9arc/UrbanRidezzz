package com.pro.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pro.pojos.Customer;
import com.pro.pojos.User;

public interface CustomerDao extends JpaRepository<Customer, Long> {

	Optional<Customer> findByEmailAndPassword(String em,String pass);
}
