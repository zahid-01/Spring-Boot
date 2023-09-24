package com.sudo.dev.Employees.service;

import com.sudo.dev.Employees.dao.EmployeeDAO;
import com.sudo.dev.Employees.dao.EmployeeRepository;
import com.sudo.dev.Employees.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    //CREATE
    @Override
    @Transactional
    public Employee createEmployee(Employee employee) {
        String firstName = employee.getFirstName().trim();
        String lastName = employee.getLastName().trim();
        String email = employee.getEmail().trim();

        if (email.length() < 3 || firstName.length() < 3 || lastName.length() < 3)
            throw new RuntimeException("Check your inputs");
        Employee employee1 = new Employee(firstName, lastName, email);
        return employeeDAO.save(employee1);
    }

    //READ
    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee getEmployee(Integer id) {
        Optional<Employee> result = employeeDAO.findById(id);

        Employee theEmployee = null;
        if (result.isPresent())
            theEmployee = result.get();
        else
            throw new RuntimeException("No Employee with that id found");

        return theEmployee;
    }

    //UPDATE
    @Override
    @Transactional
    public Employee updateEmployee(Employee employee) {
        return employeeDAO.save(employee);
    }

    //DELETE
    @Override
    @Transactional
    public void deleteById(int id) {
        employeeDAO.deleteById(id);
    }
}
