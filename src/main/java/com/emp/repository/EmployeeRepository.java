package com.emp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.bindings.EmployeeForm;
import com.emp.entites.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer>{
	
	public List<EmployeeEntity> findByAcitiveSW(String s1);

}
