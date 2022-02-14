package me.ahmedbargady.springboot_template_jinamoon.service;

import java.util.List;

import me.ahmedbargady.springboot_template_jinamoon.model.Employee;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id);

    Employee updateEmployee(Long id, Employee employee);

    Employee deleteEmployee(Long id);

}
