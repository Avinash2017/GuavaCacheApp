package com.avi.cache;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

import com.avi.cache.config.CacheConfig;
import com.avi.cache.model.Employee;
import com.avi.cache.service.EmployeeServiceImpl;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;



@RunWith(MockitoJUnitRunner.class)
public class TestCache {

	@InjectMocks
	CacheConfig cacheConfig;
	
	@Mock
	EmployeeServiceImpl employeeService;
	
	@Mock
	LoadingCache<Long, Employee> employeeCache;
	@Mock
	private CacheLoader<Long, Employee> cacheLoader;
	
	@Test
	public void test() throws Exception{
		Employee expected = getEmployee();
		when(cacheConfig.getEmployeeWithId(100L)).thenReturn(expected);
		Employee e = cacheConfig.getEmployeeWithId(100L);
		Employee e1 = cacheConfig.getEmployeeWithId(100L);
		
		assertEquals(expected, e1);
		assertEquals(expected, e);
		  for (int i = 0; i < 10; i++) {
	        	Employee emp = cacheConfig.getEmployeeWithId(100L);
	            assertThat(emp, is(expected));
	        }
		
		when(cacheLoader.load(100L)).thenReturn(expected);
        LoadingCache<Long, Employee> employeeCache = CacheBuilder.newBuilder()               
                .build(cacheLoader);

        Employee empReturned = employeeCache.get(100L);
        assertThat(empReturned, is(expected));
        
        for (int i = 0; i < 10; i++) {
        	Employee emp = employeeCache.get(100L);
            assertThat(emp, is(expected));
        }
        verify(cacheLoader, times(1)).load(100L);
	}
	private Employee getEmployee() {
		 Employee employeeExpected = new Employee();
		 employeeExpected.setEmpId(100L);
		 employeeExpected.setDepId(100);
		 employeeExpected.setEmpName("Avinash");
		 employeeExpected.setJob("Software Engineer");
		 return employeeExpected;
	}
	
}
