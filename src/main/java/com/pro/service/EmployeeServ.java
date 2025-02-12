package com.pro.service;

import java.util.List;

import com.pro.pojos.Employee;

public interface EmployeeServ {

	String AddEmp(Employee emp);
	
	List<Employee> Getemp();
	
	String DeleteEmp(Long id);
	
	String UpdateEmp(Long id,Employee emp);
	
	Employee getEmpId(Long id);
}
