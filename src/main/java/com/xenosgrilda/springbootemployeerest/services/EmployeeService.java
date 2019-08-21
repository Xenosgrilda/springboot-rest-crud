package com.xenosgrilda.springbootemployeerest.services;

import com.xenosgrilda.springbootemployeerest.dao.EmployeeDAOJPARepository;
import com.xenosgrilda.springbootemployeerest.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements EmployeeServiceInterface {

    // Hibernate JPA DAO
    // private EmployeeDAOHibernate employeeDAO;

    // Standard JPA DAO
    // private EmployeeDAOInterface employeeDAO;

    // Switching to JpaRepository
    private EmployeeDAOJPARepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeDAOJPARepository employeeDAO){
        this.employeeRepository = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = this.employeeRepository.findById(id);

        Employee employee = null;

        if (result.isPresent()){
            employee = result.get();
        } else {

            throw new RuntimeException("Employee id: " + id + " was not found");
        }

        return employee;
    }

    @Override
    public void save(Employee newEmployee) {
        this.employeeRepository.save(newEmployee);
    }

    @Override
    public void deleteById(int id) {
        this.employeeRepository.deleteById(id);
    }
}

/**
 * Two changes were made to this file:
 * - Removed "@Qualifier" from the constructor since we don't use an interface implemented by 2 classes
 * - Removed @Transactional since JpaRepository provide this functionality
 */