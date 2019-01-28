package com.avi.cache.service;

import java.util.List;
import java.util.Optional;

import com.avi.cache.model.Employee;

public interface EmployeeService {
	List<Employee> findAll();
	Employee findById(Long id);
}
