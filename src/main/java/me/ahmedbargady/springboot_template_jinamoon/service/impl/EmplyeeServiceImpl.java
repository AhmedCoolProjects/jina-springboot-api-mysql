package me.ahmedbargady.springboot_template_jinamoon.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import me.ahmedbargady.springboot_template_jinamoon.exception.ResourceNotFoundException;
import me.ahmedbargady.springboot_template_jinamoon.model.Employee;
import me.ahmedbargady.springboot_template_jinamoon.repository.EmployeeRepository;
import me.ahmedbargady.springboot_template_jinamoon.service.EmployeeService;

@Service
public class EmplyeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmplyeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        } else {
            throw new ResourceNotFoundException("Employee", "id", id);
        }
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Employee employee1 = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
        employee1.setFirstName(employee.getFirstName());
        employee1.setLastName(employee.getLastName());
        employee1.setEmail(employee.getEmail());
        employeeRepository.save(employee1);
        return employee1;
    }

    @Override
    public Employee deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
        employeeRepository.deleteById(id);
        return employee;
    }

}
