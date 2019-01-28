package com.avi.cache.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.avi.cache.model.Employee;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>  {

}
