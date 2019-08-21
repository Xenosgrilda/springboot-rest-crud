package com.xenosgrilda.springbootemployeerest.dao;

import com.xenosgrilda.springbootemployeerest.entities.Employee;

import java.util.List;

public interface EmployeeDAOInterface {

    List<Employee> findAll();
    Employee findById(int id);
    void save(Employee updatedEmployee);
    void deleteById(int id);
}
