package com.xenosgrilda.springbootemployeerest.controllers;

import com.xenosgrilda.springbootemployeerest.entities.Employee;
import com.xenosgrilda.springbootemployeerest.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeServiceHibernate) {
        this.employeeService = employeeServiceHibernate;
    }

    // ===== GET =====
    @GetMapping("/employees")
    public List<Employee> getEmployees() {

        return this.employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {

        return this.employeeService.findById(id);
    }

    // ===== POST =====
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody @NotNull Employee newEmployee) {

        // Setting ID to "0" so it always create a new Employee and not update
        newEmployee.setId(0);

        this.employeeService.save(newEmployee);

        return newEmployee;
    }

    // ===== PUT =====
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody @NotNull Employee updatedEmployee) {
        
        // An registered ID and will perform an update
        this.employeeService.save(updatedEmployee);

        return updatedEmployee;
    }

    // ===== DELETE =====
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {

        this.employeeService.deleteById(id);

        return new ResponseEntity<>("Employee " + id + " deleted.", HttpStatus.OK);
    }
}

/**
 * Remember that Jacksons is on pom.xml/classpath so it automatically converts the response to JSON
 */

/**
 * Response Entity is a class that we can use to customize our responses
 * Take a look on https://www.baeldung.com/spring-response-entity
 */