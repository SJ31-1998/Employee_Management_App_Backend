package com.upgrad.EmployeeApp.entites;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Employee
{
    @Id
    @GeneratedValue
    private Integer empId;
    private String empName;
    private Double empSal;
    private String empDept;
    

}
