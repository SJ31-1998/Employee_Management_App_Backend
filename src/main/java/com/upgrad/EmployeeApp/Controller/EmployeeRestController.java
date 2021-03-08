package com.upgrad.EmployeeApp.Controller;

import com.upgrad.EmployeeApp.Services.EmployeeService;
import com.upgrad.EmployeeApp.entites.Employee;
import com.upgrad.EmployeeApp.exceptions.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/employees")
public class EmployeeRestController {

    @Autowired
    private EmployeeService service;

    //save
    @PostMapping("/save")
    public ResponseEntity<String> saveEmployee(@RequestBody Employee employee){
       Integer id= service.saveEmployee(employee);
        return new ResponseEntity<String>("Employee '"+id+"'saved",HttpStatus.OK);
    }


    //fetch all
    @GetMapping("/all")
    public  ResponseEntity<List<Employee>> getAllEmployee(){

        List<Employee> list =service.getAllEmployee();

        return new ResponseEntity<List<Employee>>(list,HttpStatus.OK);

    }


    //fetch one
    @GetMapping("/one/{id}")
    public  ResponseEntity<Employee> getOneEmployee(@PathVariable Integer id) throws EmployeeNotFoundException {

        Employee employee =service.getOneEmployee(id);

        return new ResponseEntity<Employee>(employee,HttpStatus.OK);

    }


    //delete
    @DeleteMapping("/remove/{id}")
     public ResponseEntity<String>dleteEmployee(@PathVariable Integer id)
    {
        try {
            service.deleteEmployee(id);
        } catch (EmployeeNotFoundException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<String>("Employee '"+id+"'Deleted",HttpStatus.OK);
    }
    
    //update
    @PutMapping("/modify/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Integer id,@RequestBody Employee employee) throws EmployeeNotFoundException {
        Employee db=service.getOneEmployee(id);
        db.setEmpDept(employee.getEmpDept());
        db.setEmpName(employee.getEmpDept());
        db.setEmpSal(employee.getEmpSal());
        service.saveEmployee(db);
        return new ResponseEntity<String>("Employee '"+id+"'updated",HttpStatus.OK);
    }
}
