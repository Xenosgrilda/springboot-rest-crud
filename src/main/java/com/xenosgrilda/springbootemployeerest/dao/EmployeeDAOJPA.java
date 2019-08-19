package com.xenosgrilda.springbootemployeerest.dao;

import com.xenosgrilda.springbootemployeerest.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository(value = "employeeDAOJPA")
public class EmployeeDAOJPA implements EmployeeDAOInterface {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJPA(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        Query query = this.entityManager.createQuery("FROM Employee", Employee.class);

        return (List<Employee>) query.getResultList();
    }

    @Override
    public Employee find(int id) {
        return this.entityManager.find(Employee.class, id);
    }

    @Override
    public void add(Employee newEmp) {

        this.entityManager.persist(newEmp);
    }

    @Override
    public void update(Employee updatedEmployee) {

        // If this employee has the Id registered in DB it will update otherwise create, same as saveOrUpdate()
        this.entityManager.merge(updatedEmployee);
    }

    @Override
    public void delete(int id) {

        Query query = this.entityManager.createQuery("DELETE FROM Employee WHERE id = :empId");
        query.setParameter("empId", id);

        query.executeUpdate();
    }
}
