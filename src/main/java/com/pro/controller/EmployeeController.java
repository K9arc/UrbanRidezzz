package com.pro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pro.dto.ApiResponse;
import com.pro.pojos.Employee;
import com.pro.service.EmployeeServ;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/Employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeServ eServ;

// Adding the Details in table
@PostMapping
public ResponseEntity<?> AddEmployee(@RequestBody Employee ee) {
	
    return ResponseEntity.status(HttpStatus.CREATED).body(new com.pro.dto.ApiResponse(eServ.AddEmp(ee)));
}

// fetching all the details
@GetMapping
public ResponseEntity<?> getAllEmp() {
	List<Employee>epp=eServ.Getemp();
	if(epp.isEmpty())
	{
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	return ResponseEntity.ok(epp);
}

// Deleting the details by ID
@DeleteMapping("/{eid}")
ResponseEntity<?> deleteEmp(@PathVariable Long eid)
{
	try {
		return ResponseEntity.ok(new ApiResponse(eServ.DeleteEmp(eid)));
	}catch(RuntimeException excep)
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(excep.getMessage()));
	}
}

// Updating the Employee Details by Id
@PutMapping("/{eid}")
public ResponseEntity<?> UpdateEmp(@PathVariable Long eid, @RequestBody Employee emp) {
   
    return ResponseEntity.ok(new ApiResponse(eServ.UpdateEmp(eid, emp)));
}

// fetching the detail of Employee by Id
@GetMapping("/{eid}")
public ResponseEntity<?> getById(@PathVariable Long eid) {
    return  ResponseEntity.ok(eServ.getEmpId(eid));
}


}
