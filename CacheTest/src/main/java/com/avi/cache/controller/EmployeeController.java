package com.avi.cache.controller;

import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avi.cache.config.CacheConfig;
import com.avi.cache.model.Employee;
import com.avi.cache.service.EmployeeService;

@RestController
@RequestMapping(value ="/cache")
public class EmployeeController {

	//@Autowired
	//private EmployeeService employeeService;
	@Autowired
	CacheConfig cacheConfig;

	@RequestMapping(value ="/employees")
	public List<Employee> getAllEmployees(){
		List<Employee> list = null;
		try {
			list = cacheConfig.getEmployeeCacheList().get("ALL_EMPS");
			System.out.println(list.size());
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@RequestMapping(value ="/employees/{id}")
	public Employee getById(@PathVariable("id") Long id ){
		try {
			return cacheConfig.getEmployeeCache().get(id);
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return null;
	}

}
