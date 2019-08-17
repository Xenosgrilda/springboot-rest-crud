package com.xenosgrilda.springbootemployeerest.dao;

import com.xenosgrilda.springbootemployeerest.entities.Employee;

import java.util.List;

public interface EmployeeDAOInterface {

    List<Employee> findAll();
}
