package com.pro.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pro.pojos.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Long> {
	

}
