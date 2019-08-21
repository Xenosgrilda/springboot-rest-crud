package com.xenosgrilda.springbootemployeerest.services;

import com.xenosgrilda.springbootemployeerest.entities.Employee;

import java.util.List;

public interface EmployeeServiceInterface {

    List<Employee> findAll();
    Employee findById(int id);
    void save(Employee newEmployee);
    void deleteById(int id);
}
