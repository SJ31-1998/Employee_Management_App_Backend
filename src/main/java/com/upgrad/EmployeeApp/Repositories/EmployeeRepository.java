package com.upgrad.EmployeeApp.Repositories;

import com.upgrad.EmployeeApp.entites.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> { }
