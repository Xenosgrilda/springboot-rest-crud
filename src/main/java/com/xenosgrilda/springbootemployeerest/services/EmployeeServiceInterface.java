package com.xenosgrilda.springbootemployeerest.services;

import com.xenosgrilda.springbootemployeerest.entities.Employee;

import java.util.List;

public interface EmployeeServiceInterface {

    List<Employee> getList();
    Employee getSingle(int id);
    void add(Employee newEmployee);
    void delete(int id);
    void update(Employee updatedEmployee);
}
