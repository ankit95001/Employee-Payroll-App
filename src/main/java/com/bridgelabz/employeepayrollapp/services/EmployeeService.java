package com.bridgelabz.employeepayrollapp.services;

import com.bridgelabz.employeepayrollapp.entities.Employee;
import com.bridgelabz.employeepayrollapp.repositories.EmployeeRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class EmployeeService {
    final EmployeeRepository employeeRepository;

    EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }
    public List<Employee> getAllEmployee(){
        log.info("Fetching all employees from DB");
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id){
        log.info("Fetching employee with ID: {}", id);
        return employeeRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Employee with ID {} not found!", id);
                    return new RuntimeException("Employee not found");
                });
    }

    public Employee saveEmployee(Employee employee){
        log.info("Saving new employee: {}", employee);
        return employeeRepository.save(employee);
    }

    @Transactional
    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Employee existingEmployee = getEmployeeById(id);
        existingEmployee.setName(updatedEmployee.getName());
        existingEmployee.setSalary(updatedEmployee.getSalary());
        log.info("Updating employee with ID: {}", id);
        return employeeRepository.save(existingEmployee);
    }

    @Transactional
    public void deleteEmployee(Long id) {
        log.warn("Deleting employee with ID: {}", id);
        if (!employeeRepository.existsById(id)) {
            log.error("Employee with ID {} not found!", id);
            throw new RuntimeException("Employee not found");
        }
        employeeRepository.deleteById(id);
    }
}
