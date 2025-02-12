package com.pro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.Dao.EmployeeDao;
import com.pro.Exception.ResourceNotFoundException;
import com.pro.pojos.Employee;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeServImpl implements EmployeeServ {
	
	@Autowired
	private EmployeeDao eDao;

	@Override
	public String AddEmp(Employee emp) {
		Employee ep=eDao.save(emp);
		return "Details Added Successfully!!"+ep;
	}

	@Override
	public List<Employee> Getemp() {
		List<Employee>eop=eDao.findAll();
		return eop;
	}

	@Override
	public String DeleteEmp(Long id) {
		if(eDao.existsById(id))
		{
			eDao.deleteById(id);
			return "Deleted!!";
		}
		throw new ResourceNotFoundException("Id Not found!!");
	}

	@Override
	public String UpdateEmp(Long id, Employee emp) {
		if(eDao.existsById(id))
		{
			Employee ep=eDao.save(emp);
			return "Details Updated!! "+ep;
		}
		throw new ResourceNotFoundException("Id not Found!!");
	}

	@Override
	public Employee getEmpId(Long id) {
		
		return eDao.findById(id).orElseThrow(()->new ResourceNotFoundException("Invalid Id!"));
	}

}
