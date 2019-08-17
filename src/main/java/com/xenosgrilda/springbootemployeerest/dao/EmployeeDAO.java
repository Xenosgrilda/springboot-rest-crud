package com.xenosgrilda.springbootemployeerest.dao;

import com.xenosgrilda.springbootemployeerest.entities.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAO implements EmployeeDAOInterface {

    private EntityManager entityManager;

    // Here we're using Constructor Injection of the EntityManager Bean
    @Autowired
    public EmployeeDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional // Make sure to choose the org.springframework.transaction.annotation.Transactional
    public List<Employee> findAll() {

        // Getting the current Hibernate Session
        Session session = entityManager.unwrap(Session.class);

        // Creating query
        // In this example we're using the native Hibernate API
        Query<Employee> query =  session.createQuery("FROM Employee", Employee.class);

        // Executing Query and getting result list
        return query.getResultList();
    }
}

/**
 * This is our Bean that we'll use to make DB calls, since it's a Bean we need to annotate it with @Component or a
 * derived, for database stuff, we use @Repository, so when we use the @Autowired it's configured
 */

/**
 * Remember that SpringBoot created the "EntityManager" automatically for us based on our pom.xml and application.properties
 * We can make use of this Bean, and therefore, making calls to DB using JPA implementation.
 */