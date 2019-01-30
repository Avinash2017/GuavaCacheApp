package com.avi.cache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avi.cache.model.Person;
import com.avi.cache.repo.HibernateRepo;

@Service
public class HibernateServiceImpl implements HibernateService {
	
	@Autowired
	HibernateRepo hibernateRepo;
	
	@Override
	public void createPerson(Person p) {
		hibernateRepo.createPerson(p);
	}

	@Override
	public Person getPersonByName(String name) {
		return hibernateRepo.getPersonByName(name);
	}


}
