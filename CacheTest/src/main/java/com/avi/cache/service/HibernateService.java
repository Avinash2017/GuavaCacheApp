package com.avi.cache.service;

import com.avi.cache.model.Person;

public interface HibernateService {
	public void createPerson(Person p);
	public Person getPersonByName(String name);
}
