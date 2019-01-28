package com.avi.cache.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "EMP_TEST")
@Entity
public class Employee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "EMP_ID")
	private Long empId;
		
	@Column(name = "EMP_NAME")
	private String empName;
	
	@Column(name = "SALARY")
	private Integer salary;
	
	@Column(name = "DEPT_ID")
	private Integer depId;
	
	@Column(name = "JOINING_DATE")
	private Date joiningDate;
	
	@Column(name = "JOB")
	private String job;

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Integer getDepId() {
		return depId;
	}

	public void setDepId(Integer depId) {
		this.depId = depId;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return "empId=" + empId + ", empName=" + empName
				+ ", salary=" + salary + ", depId=" + depId + ", joiningDate="
				+ joiningDate + ", job=" + job + "";
	}
	
}
