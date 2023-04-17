package com.emp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emp.bindings.EmployeeForm;
import com.emp.entites.EmployeeEntity;
import com.emp.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@PostMapping("/emp")
	public ResponseEntity<String> employee(@RequestBody EmployeeForm form) {
		var status = service.upsert(form);
		return new ResponseEntity<>(status, HttpStatus.CREATED);
	}
	
	@GetMapping("/emps")
	public ResponseEntity<List<EmployeeForm>> getAllEmployees(){
		List<EmployeeForm> allEmployees = service.getAllEmployees();
		return new ResponseEntity<>(allEmployees, HttpStatus.OK);
	}
	
	@GetMapping("/emp/{eid}")
	public ResponseEntity<EmployeeEntity> getEmployee(@PathVariable Integer eid) {
	 EmployeeEntity employee = service.getEmployee(eid);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	
	@DeleteMapping("/emp/{eid}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer eid) {
		String deleteEmployee = service.deleteEmployee(eid);
		return new ResponseEntity<>(deleteEmployee, HttpStatus.OK);
		 
	}
	

}
