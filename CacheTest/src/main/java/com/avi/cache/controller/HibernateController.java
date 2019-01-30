package com.avi.cache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.avi.cache.model.Person;
import com.avi.cache.service.HibernateService;

@RestController
@RequestMapping(value ="/hibernate")
public class HibernateController {
	@Autowired
	HibernateService hibernateService;
	
	@RequestMapping(value ="/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createPerson(@RequestBody Person person){
		hibernateService.createPerson(person);
	}
	
	@RequestMapping(value ="/get_person_by_name/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Person getPersonDetails(@PathVariable("name") String name){
		return hibernateService.getPersonByName(name);
	}
}
