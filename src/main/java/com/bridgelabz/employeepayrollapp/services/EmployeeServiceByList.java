package com.bridgelabz.employeepayrollapp.services;

import com.bridgelabz.employeepayrollapp.entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeServiceByList {
    final List<Employee> employeeList = new ArrayList<>();

    // Get all employees
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    // Get employee by ID
    public Employee getEmployeeById(Long id) {
        return employeeList.stream()
                .filter(emp -> emp.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    // Save (Add) employee
    public Employee saveEmployee(Employee employee) {
        employee.setId((long) (employeeList.size() + 1)); // Auto-increment ID
        employeeList.add(employee);
        return employee;
    }

    // Update employee
    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Optional<Employee> existingEmployeeOpt = employeeList.stream()
                .filter(emp -> emp.getId().equals(id))
                .findFirst();

        if (existingEmployeeOpt.isPresent()) {
            Employee existingEmployee = existingEmployeeOpt.get();
            existingEmployee.setName(updatedEmployee.getName());
            existingEmployee.setSalary(updatedEmployee.getSalary());
            return existingEmployee;
        } else {
            throw new RuntimeException("Employee not found");
        }
    }

    // Delete employee
    public void deleteEmployee(Long id) {
        employeeList.removeIf(emp -> emp.getId().equals(id));
    }
}
