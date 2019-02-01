package com.avi.cache.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Table(name = "AVI_PERSON")
@Entity
public class Person {
	@Override
	public String toString() {
		return "Person [personId=" + personId + ", name=" + name
				+ ", dateOfBirth=" + dateOfBirth + ", address=" + address + "]";
	}
	@GeneratedValue(strategy  = GenerationType.AUTO)
	@javax.persistence.Id
	@Column(name = "person_id")
	private Integer personId;

	@Column(name = "person_name")
	private String name;

	@Column(name = "date_of_birth")	
	private Date dateOfBirth;

	@Column(name = "person_salary")	
	private Integer personSalary;

	@Column(name = "person_age")	
	private Integer personAge;

	@Cascade(CascadeType.ALL)
	@OneToOne
	@JoinColumn(name = "address_id")
	Address address;

	//List<Car> car;


	public Integer getPersonSalary() {
		return personSalary;
	}
	public void setPersonSalary(Integer personSalary) {
		this.personSalary = personSalary;
	}
	public Integer getPersonAge() {
		return personAge;
	}
	public void setPersonAge(Integer personAge) {
		this.personAge = personAge;
	}
	public Integer getPersonId() {
		return personId;
	}
	public void setPersonId(Integer personId) {
		this.personId = personId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	/*public List<Car> getCar() {
		return car;
	}
	public void setCar(List<Car> car) {
		this.car = car;
	}*/

}
