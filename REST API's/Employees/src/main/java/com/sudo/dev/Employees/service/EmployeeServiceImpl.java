package com.sudo.dev.Employees.service;

import com.sudo.dev.Employees.dao.EmployeeDAO;
import com.sudo.dev.Employees.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    //CREATE
    @Override
    @Transactional
    public String createEmployee(Employee employee) {
        String firstName = employee.getFirstName().trim();
        String lastName = employee.getLastName().trim();
        String email = employee.getEmail().trim();

        if(email.length() < 3 || firstName.length() <3 || lastName.length() < 3)
            throw new RuntimeException("Check your inputs");

        return employeeDAO.createEmployee(firstName, lastName, email);
    }

    //READ
    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee getEmployee(int id) {
        Employee employee = employeeDAO.getEmployee(id);

        if(employee == null)
            throw new RuntimeException("No Employee with that id found");

        return employee;
    }

    //UPDATE
    @Override
    @Transactional
    public Employee updateEmployee(Employee employee) {
        return employeeDAO.updateEmployee(employee);
    }

    //DELETE
    @Override
    @Transactional
    public void deleteById(int id) {
        employeeDAO.deleteById(id);
    }
}
