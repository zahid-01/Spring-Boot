package com.sudo.dev.Employees.service;

import com.sudo.dev.Employees.entity.Employee;

import java.util.List;

public interface EmployeeService {
    //CREATE
    public Employee createEmployee(Employee employee);

    //READ
    public List<Employee> findAll();
    public Employee getEmployee(Integer id);

    //UPDATE
    public Employee updateEmployee(Employee employee);

    //DELETE
    public void deleteById(int id);

}
