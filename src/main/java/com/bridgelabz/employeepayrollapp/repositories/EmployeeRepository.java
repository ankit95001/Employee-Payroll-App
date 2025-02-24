package com.bridgelabz.employeepayrollapp.repositories;


import com.bridgelabz.employeepayrollapp.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
