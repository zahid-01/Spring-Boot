package com.sudo.dev.Employees.dao;

import com.sudo.dev.Employees.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    //CREATE
    public String createEmployee(String firstName, String lastName, String email );

    //READ
    public List<Employee> findAll();
    public Employee getEmployee(int id);

    //UPDATE
    public Employee updateEmployee(Employee employee);

    //DELETE
    public void deleteById(int id);


}
