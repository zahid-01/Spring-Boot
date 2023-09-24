package com.sudo.dev.Employees.REST;

import com.sudo.dev.Employees.dao.EmployeeDAO;
import com.sudo.dev.Employees.dao.EmployeeDAOImpl;
import com.sudo.dev.Employees.entity.Employee;
import com.sudo.dev.Employees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class employeeController {
    private final EmployeeService employeeService;

    @Autowired
    public employeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    //CREATE
    @PostMapping("/employees")
    public String createNewEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }
    //READ
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee findById(@PathVariable int id){
        return employeeService.getEmployee(id);
    }

    //UPDATE
    @PutMapping("/employees/{id}")
    public Employee updateById(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }

    //DELETE
    @DeleteMapping("/employees/{id}")
    public void deleteById(@PathVariable int id){
        employeeService.deleteById(id);
    }
}
