package com.avi.cache;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


import com.avi.cache.config.CacheConfig;
import com.avi.cache.model.Employee;
import com.avi.cache.service.EmployeeService;
import com.avi.cache.service.EmployeeServiceImpl;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Lists;



@RunWith(MockitoJUnitRunner.class)
public class CacheTestApplicationTests {
	
	//@Mock
	//private CacheLoader<String, List<Employee>> cacheLoader;
	
	
	
	@Before
	public void setUp(){
		getEmployee();
	}
	
	private Employee getEmployee() {
		 Employee employeeExpected = new Employee();
		 employeeExpected.setEmp_id(100L);
		 employeeExpected.setDept_id(100);
		 employeeExpected.setEmp_name("Avinash");
		 employeeExpected.setJob("Software Engineer");
		 return employeeExpected;
	}

	
	
	
	@Test
	public void testSpy(){
		
		try {
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
			
			 EmployeeService employeeService  = Mockito.mock(EmployeeService.class);
			 CacheConfig config = new CacheConfig(employeeService);
			 CacheConfig configSpy = Mockito.spy(config);
			 configSpy.setUpEmployeeCacheList();
			 List<Employee> sourceList = Lists.newArrayList(employeeExpected,employeeExpected2);
			 Mockito.doReturn(sourceList).when(configSpy).getEmployees();
			 configSpy.getEmployees();
			 configSpy.getEmployees();
			 verify(configSpy,times(2)).getEmployees();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
/*	@Test
	@Ignore
    public void testCacheLoaderCalledOnlyOnce() throws Exception {
		Employee employeeExpected = getEmployee();
        when(cacheLoader.load(100L)).thenReturn(employeeExpected);
        LoadingCache<Long, Employee> employeeCache = CacheBuilder.newBuilder()               
                .build(cacheLoader);

        Employee empReturned = employeeCache.get(100L);
        assertThat(empReturned, is(employeeExpected));
        
        for (int i = 0; i < 10; i++) {
        	Employee emp = employeeCache.get(100L);
            assertThat(emp, is(employeeExpected));
        }
        verify(cacheLoader, times(1)).load(100L);
    }
	
	@Ignore
	@Test
    public void testCacheLoaderCalledInitiallyAndAfterExpiration() throws Exception {
		Employee employeeExpected = getEmployee();
        when(cacheLoader.load(100L)).thenReturn(employeeExpected);
        LoadingCache<Long, Employee> employeeCache = CacheBuilder.newBuilder()
                .expireAfterAccess(500, TimeUnit.MILLISECONDS)
                .build(cacheLoader);

        Employee empActual = employeeCache.get(100L);
        assertThat(empActual, is(employeeExpected));

        Thread.sleep(1000);

        Employee emp1 = employeeCache.get(100L);
        assertThat(emp1, is(employeeExpected));
        verify(cacheLoader, times(2)).load(100L);
    }
	*/
}

