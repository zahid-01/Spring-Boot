package com.sudo.dev.Employees.dao;

import com.sudo.dev.Employees.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
