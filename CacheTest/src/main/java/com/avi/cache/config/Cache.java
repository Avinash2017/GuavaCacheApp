package com.avi.cache.config;

import java.util.List;
import java.util.concurrent.ExecutionException;

import com.avi.cache.model.Employee;

public interface Cache {
	public Employee getEmployeeWithId(Long id);
	public List<Employee> getEmployees() throws ExecutionException;
}
