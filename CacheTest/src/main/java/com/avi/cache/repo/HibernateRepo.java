package com.avi.cache.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.avi.cache.model.Person;

@Repository
public class HibernateRepo{
	@Autowired
	EntityManager entityManager;
	
	public void createPerson(Person p){
		System.out.println(p.getName());
		SessionFactory sessionFactory = entityManager.getEntityManagerFactory().unwrap( SessionFactory.class );
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		//session.save(p);
		session.save(p);
		tr.commit();
		System.out.println("person successfully inserted...");
	}

	public Person getPersonByName(String name) {
		SessionFactory sessionFactory = entityManager.getEntityManagerFactory().unwrap( SessionFactory.class );
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Object[]> personCriteria = builder.createQuery(Object[].class);
		Root<Person> personRoot = personCriteria.from(Person.class);
		personCriteria.multiselect(personRoot.get("name"),personRoot.get("address").get("city"));
		personCriteria.where(builder.equal(personRoot.get("name"), name));
		List<Object[]> rows = session.createQuery(personCriteria).list();
		rows.stream().forEach(o ->System.out.println(o[1]));
		System.out.println("------");
		for(Object[] row : rows){
			System.out.println(row[0]+ " "+row[1]);
		}
		return null;
	}
	
}
