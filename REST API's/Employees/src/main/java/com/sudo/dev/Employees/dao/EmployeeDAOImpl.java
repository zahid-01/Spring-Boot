package com.sudo.dev.Employees.dao;

import com.sudo.dev.Employees.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    //Entity Manager
    private final EntityManager entityManager;
    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    //CREATE
    @Override
    public String createEmployee(String firstName, String lastName, String email) {
        entityManager.persist(new Employee(firstName, lastName, email));
        return "Created Successfully";
    }

    //READ
    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> employees = entityManager.createQuery("FROM Employee",Employee.class);
        return employees.getResultList();
    }

    @Override
    public Employee getEmployee(int id) {
        return entityManager.find(Employee.class, id);
    }

    //UPDATE
    @Override
    public Employee updateEmployee(Employee employee) {
        return entityManager.merge(employee);
    }

    //DELETE
    @Override
    public void deleteById(int id) {
        Employee employee = entityManager.find(Employee.class, id);

        entityManager.remove(employee);
    }
}
