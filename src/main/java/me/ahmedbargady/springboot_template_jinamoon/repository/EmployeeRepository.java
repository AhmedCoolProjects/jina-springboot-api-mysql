package me.ahmedbargady.springboot_template_jinamoon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import me.ahmedbargady.springboot_template_jinamoon.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
