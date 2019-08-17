package com.xenosgrilda.springbootemployeerest.controllers;

import com.xenosgrilda.springbootemployeerest.dao.EmployeeDAO;
import com.xenosgrilda.springbootemployeerest.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeController( EmployeeDAO employeeDAO ) {
        this.employeeDAO = employeeDAO;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {

        return this.employeeDAO.findAll();
    }
}

/**
 * Remember that Jacksons is on pom.xml/classpath so it automatically converts the response to JSON
 */
