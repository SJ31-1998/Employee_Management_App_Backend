package com.upgrad.EmployeeApp.Services;

import com.upgrad.EmployeeApp.Repositories.EmployeeRepository;
import com.upgrad.EmployeeApp.entites.Employee;
import com.upgrad.EmployeeApp.exceptions.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository repo;

    @Override
    public Integer saveEmployee(Employee e) {
        Integer id=repo.save(e).getEmpId();
        return id;
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> list=repo.findAll();
        return list;
    }

    @Override
    public Employee getOneEmployee(Integer id) throws EmployeeNotFoundException {
        Optional<Employee> opt=repo.findById(id);
        Employee emp=opt.orElseThrow(()-> new EmployeeNotFoundException("Employee Not Exist"));
        return emp;
    }

    @Override
    public void deleteEmployee(Integer id) throws EmployeeNotFoundException {
        Employee emp= getOneEmployee(id);
        repo.delete(emp);
    }

//    @Override
//    public void updateEmployee() {
//
//    }


}
