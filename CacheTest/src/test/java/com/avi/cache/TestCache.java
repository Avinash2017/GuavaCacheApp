package com.avi.cache;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

import org.mockito.junit.MockitoJUnitRunner;

import com.avi.cache.config.CacheConfig;
import com.avi.cache.model.Employee;
import com.avi.cache.service.EmployeeServiceImpl;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Lists;



@RunWith(MockitoJUnitRunner.class)
public class TestCache {

	@Mock
	private CacheConfig cacheConfig;
	
	@Mock
	private EmployeeServiceImpl employeeService;
	
	@Mock
	private LoadingCache<String, List<Employee>> employeeCacheList;
	
	@Mock
	private CacheLoader<String, List<Employee>> cacheLoader;
	
	@Test
	public void test() throws Exception{
		
		 
		 Employee employeeExpected = new Employee();
		 employeeExpected.setEmp_id(100L);
		 employeeExpected.setDept_id(100);
		 employeeExpected.setEmp_name("Avinash");
		 employeeExpected.setJob("Software Engineer");
		 
		 Employee employeeExpected2 = new Employee();
		 employeeExpected.setEmp_id(100L);
		 employeeExpected.setDept_id(100);
		 employeeExpected.setEmp_name("Avinash");
		 employeeExpected.setJob("Software Engineer");
		 
		 List<Employee> sourceList = Lists.newArrayList(employeeExpected,employeeExpected2);
		 
		 when(cacheConfig.getEmployees()).thenReturn(sourceList);
		 
	/*	 LoadingCache<String, List<Employee>> employeeCacheList = CacheBuilder.newBuilder()               
				 .build(new CacheLoader<String, List<Employee>>() {
					 @Override
					 public List<Employee> load(String id) throws Exception {
						 return sourceList;
					 }

		});
		
		cacheConfig.setEmployeeCacheList(employeeCacheList);*/
		/*
		cacheConfig.getEmployees();
		cacheConfig.getEmployees();
		
		verify(cacheConfig,times(2)).getEmployees();
		
		employeeCacheList.get("ALL_EMPS");
		employeeCacheList.get("ALL_EMPS");

		
		verify(cacheLoader,times(2)).load("ALL_EMPS");*/
		
	}
	private Employee getEmployee() {
		 Employee employeeExpected = new Employee();
		 employeeExpected.setEmp_id(100L);
		 employeeExpected.setDept_id(100);
		 employeeExpected.setEmp_name("Avinash");
		 employeeExpected.setJob("Software Engineer");
		 return employeeExpected;
	}
	
}
