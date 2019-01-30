/*package com.avi.cache;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.avi.cache.model.Employee;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;



@RunWith(MockitoJUnitRunner.class)
public class CacheTestApplicationTests {
	
	@Mock
	private CacheLoader<Long, Employee> cacheLoader;
	
	
	@Before
	public void setUp(){
		getEmployee();
	}
	
	private Employee getEmployee() {
		 Employee employeeExpected = new Employee();
		 employeeExpected.setEmpId(100L);
		 employeeExpected.setDepId(100);
		 employeeExpected.setEmpName("Avinash");
		 employeeExpected.setJob("Software Engineer");
		 return employeeExpected;
	}

	@Test
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
	
}

*/