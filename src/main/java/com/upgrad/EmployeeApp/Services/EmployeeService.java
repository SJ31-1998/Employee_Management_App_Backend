package com.upgrad.EmployeeApp.Services;

import com.upgrad.EmployeeApp.entites.Employee;
import com.upgrad.EmployeeApp.exceptions.EmployeeNotFoundException;

import java.util.List;

public interface EmployeeService
{
    Integer saveEmployee(Employee e);
    List<Employee> getAllEmployee();
//    void updateEmployee();
    void deleteEmployee(Integer Id) throws EmployeeNotFoundException;
    Employee getOneEmployee(Integer Id) throws EmployeeNotFoundException;
}
