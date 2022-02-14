package me.ahmedbargady.springboot_template_jinamoon.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.ahmedbargady.springboot_template_jinamoon.model.Employee;
import me.ahmedbargady.springboot_template_jinamoon.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }

    // build create employee api
    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    // build get all employees api
    @GetMapping
    public ResponseEntity<Iterable<Employee>> getAllEmployees() {
        return new ResponseEntity<Iterable<Employee>>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    // build get employee by id api
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    // build update employee api
    @PostMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.updateEmployee(id, employee), HttpStatus.OK);
    }

    // build delete employee api
    @PostMapping("/delete/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") Long id) {
        return new ResponseEntity<Employee>(employeeService.deleteEmployee(id), HttpStatus.OK);
    }
}
