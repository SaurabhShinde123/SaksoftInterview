package com.emp.service;

import java.util.List;

import com.emp.bindings.EmployeeForm;
import com.emp.entites.EmployeeEntity;

public interface EmployeeService {

	String upsert(EmployeeForm emp);

	List<EmployeeForm> getAllEmployees();

	EmployeeEntity getEmployee(Integer eid);

	String deleteEmployee(Integer eid);

}
