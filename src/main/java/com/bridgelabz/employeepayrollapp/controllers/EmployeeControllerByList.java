package com.bridgelabz.employeepayrollapp.controllers;

import com.bridgelabz.employeepayrollapp.entities.Employee;
import com.bridgelabz.employeepayrollapp.services.EmployeeService;
import com.bridgelabz.employeepayrollapp.services.EmployeeServiceByList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeControllerByList {

    private EmployeeServiceByList employeeService;
    EmployeeControllerByList(EmployeeServiceByList employeeServiceByList){
        this.employeeService=employeeServiceByList;
    }
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "Employee deleted successfully";
    }
}

