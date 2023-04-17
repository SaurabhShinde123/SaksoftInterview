package com.emp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.bindings.EmployeeForm;
import com.emp.entites.EmployeeEntity;
import com.emp.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repo;
	
	@Override
	public String upsert(EmployeeForm emp) {
		
		EmployeeEntity entity = new EmployeeEntity();
		
		BeanUtils.copyProperties(emp, entity);
		
		entity.setAcitiveSW("Y");
		EmployeeEntity save = repo.save(entity);
		
		
		return "SUCCCESS";
	}

	@Override
	public List<EmployeeForm> getAllEmployees() {
		
		
		List<EmployeeEntity> employees = repo.findByAcitiveSW("Y");
	//	List<EmployeeEntity> employees = repo.findAll();
		
		
		List<EmployeeForm> response = new ArrayList<>();
		for (EmployeeEntity employee : employees) {
			EmployeeForm ef = new EmployeeForm();
			BeanUtils.copyProperties(employee, ef);
			response.add(ef);
		}
		
		return response;
	}

	@Override
	public EmployeeEntity getEmployee(Integer eid) {

		Optional<EmployeeEntity> findById = repo.findById(eid);
		
		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public String deleteEmployee(Integer eid) {

	 Optional<EmployeeEntity> findById = repo.findById(eid);
		
		
		if (findById.isPresent()) {
			EmployeeEntity employeeEntity = findById.get();
			employeeEntity.setAcitiveSW("N");
			repo.save(employeeEntity);
		}
		
		return "SUCCESS";
	}

}
