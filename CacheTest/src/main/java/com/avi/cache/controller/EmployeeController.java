package com.avi.cache.controller;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avi.cache.config.Cache;
import com.avi.cache.model.Employee;

@RestController
@RequestMapping(value ="/cache")
public class EmployeeController {

	//@Autowired
	//private EmployeeService employeeService;
	@Autowired
	Cache cache;

	@RequestMapping(value ="/employees")
	public List<Employee> getAllEmployees() throws ExecutionException{
			return cache.getEmployees();
	}

	@RequestMapping(value ="/employees/{id}")
	public Employee getById(@PathVariable("id") Long id ){
			return cache.getEmployeeWithId(id);
	}

}
