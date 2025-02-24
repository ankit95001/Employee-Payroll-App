package com.bridgelabz.employeepayrollapp.controllers;

import com.bridgelabz.employeepayrollapp.entities.Employee;
import com.bridgelabz.employeepayrollapp.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    final EmployeeService employeeService;
    final Employee employee;

    EmployeeController(EmployeeService employeeService,Employee employee){
        this.employeeService=employeeService;
        this.employee=employee;
    }

    @GetMapping
    public String welcomeEmployee(){
        return "Welcome to Employee Payroll App!";
    }


    @GetMapping("/all")
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeByID(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String name, @RequestParam String department, @RequestParam Double salary ){
        employee.setName(name);
        employee.setId(null);
        employee.setSalary(salary);
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "Employee deleted successfully";
    }
}
