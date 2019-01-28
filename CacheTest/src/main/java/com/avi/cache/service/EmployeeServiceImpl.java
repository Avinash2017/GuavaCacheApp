package com.avi.cache.service;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avi.cache.config.CacheConfig;
import com.avi.cache.model.Employee;
import com.avi.cache.repo.EmployeeRepo;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Override
	public List<Employee> findAll() {
		return employeeRepo.findAll();
		
	}

	@Override
	public Employee findById(Long id) {
		return employeeRepo.getOne(id);
	}

}
