package com.avi.cache.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.avi.cache.model.Address;
import com.avi.cache.model.Person;
import com.avi.cache.model.Response;

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
		/*Query q = session.createQuery("from Person p where p.name =:name",Person.class);
		q.setParameter("name", name);
		Person p = (Person) q.getSingleResult();*/
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Person> criteriaQuery = builder.createQuery(Person.class);
		Root<Person> root = criteriaQuery.from(Person.class);
		criteriaQuery.select(root);		
		criteriaQuery.where(builder.equal(root.get("name"), name));
		Person p = session.createQuery(criteriaQuery).getSingleResult();
		return p;
	}
	
}
