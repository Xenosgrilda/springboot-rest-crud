package com.xenosgrilda.springbootemployeerest.dao;

import com.xenosgrilda.springbootemployeerest.entities.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOHibernate implements EmployeeDAOInterface {

    private EntityManager entityManager;

    // Here we're using Constructor Injection of the EntityManager Bean
    @Autowired
    public EmployeeDAOHibernate(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        // Getting the current Hibernate Session
        Session session = this.entityManager.unwrap(Session.class);

        // Creating query
        // In this example we're using the native Hibernate API
        Query<Employee> query =  session.createQuery("FROM Employee", Employee.class);

        // Executing Query and getting result list
        return query.getResultList();
    }

    @Override
    public Employee findById(int id) {

        Session session = this.entityManager.unwrap(Session.class);

        return session.get(Employee.class, id);
    }

    @Override
    public void save(Employee newEmp) {

        Session session = this.entityManager.unwrap(Session.class);

        session.saveOrUpdate(newEmp);
    }

    @Override
    public void deleteById(int id) {
        Session session = this.entityManager.unwrap(Session.class);

        Query query = session.createQuery("DELETE FROM Employee WHERE id = :empId");
        query.setParameter("empId", id);

        query.executeUpdate();
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

/**
 * It seems that this class "HibernateJpaAutoConfiguration" creates automatically the "EntityManagerFactory" for us
 */