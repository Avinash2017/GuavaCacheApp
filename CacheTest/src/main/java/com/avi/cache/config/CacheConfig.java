package com.avi.cache.config;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.avi.cache.model.Employee;
import com.avi.cache.service.EmployeeService;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

@Component
public class CacheConfig implements Cache{	
	
	private LoadingCache<Long, Employee> employeeCache;
	private LoadingCache<String, List<Employee>> employeeCacheList;
	@Autowired	
	private EmployeeService employeeService;

	public LoadingCache<String, List<Employee>> getEmployeeCacheList() {
		return employeeCacheList;
	}

	public void setEmployeeCacheList(
			LoadingCache<String, List<Employee>> employeeCacheList) {
		this.employeeCacheList = employeeCacheList;
	}

	
	public LoadingCache<Long, Employee> getEmployeeCache() {
		return employeeCache;
	}

	public void setEmployeeCache(LoadingCache<Long, Employee> employeeCache) {
		this.employeeCache = employeeCache;
	}


	@PostConstruct
	private void setupCache() {
		System.out.print("in post construct");
		setUpEmployeeCache();
		setUpEmployeeCacheList();
	}

	private void setUpEmployeeCache() {
		this.employeeCache = CacheBuilder.newBuilder()
				.expireAfterWrite(20, TimeUnit.SECONDS)
				.build(new CacheLoader<Long, Employee>() {
					@Override
					public Employee load(Long id) throws Exception {
						return getEmployeeById(id);
					}

				});
		System.out.println(this.employeeCache);
	}
	private void setUpEmployeeCacheList() {
		this.employeeCacheList = CacheBuilder.newBuilder()
				.expireAfterWrite(20, TimeUnit.SECONDS)
				.build(new CacheLoader<String, List<Employee>>() {
					@Override
					public List<Employee> load(String id) throws Exception {
						return getAllEmployees();
					}

				});
	}

	private Employee getEmployeeById(Long id) {
		return employeeService.findById(id);
	}

	private List<Employee> getAllEmployees() {
		return employeeService.findAll();
	}

	@Override
	public Employee getEmployeeWithId(Long id) {
		try {
			return employeeCache.get(id);
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Employee> getEmployees() throws ExecutionException {
		return employeeCacheList.get("ALL_EMPS");
	}

	



}
