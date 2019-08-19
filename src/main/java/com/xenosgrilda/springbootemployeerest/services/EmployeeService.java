package com.xenosgrilda.springbootemployeerest.services;

import com.xenosgrilda.springbootemployeerest.dao.EmployeeDAOHibernate;
import com.xenosgrilda.springbootemployeerest.dao.EmployeeDAOInterface;
import com.xenosgrilda.springbootemployeerest.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService implements EmployeeServiceInterface {

//    private EmployeeDAOHibernate employeeDAO;
    // Switching to JPA DAO
    private EmployeeDAOInterface employeeDAO;

    @Autowired
    // Using @Qualifier because there's more than 1 @Bean that implements EmployeeDAOInterface
    public EmployeeService(@Qualifier("employeeDAOJPA") EmployeeDAOInterface employeeDAO){
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> getList() {
        return this.employeeDAO.findAll();
    }

    @Override
    public Employee getSingle(int id) {
        return this.employeeDAO.find(id);
    }

    @Override
    @Transactional
    public void add(Employee newEmployee) {
        this.employeeDAO.add(newEmployee);
    }

    @Override
    @Transactional // Make sure to choose the org.springframework.transaction.annotation.Transactional
    public void delete(int id) {
        this.employeeDAO.delete(id);
    }

    @Override
    @Transactional
    public void update(Employee updateEmployee) {
        this.employeeDAO.update(updateEmployee);
    }
}
