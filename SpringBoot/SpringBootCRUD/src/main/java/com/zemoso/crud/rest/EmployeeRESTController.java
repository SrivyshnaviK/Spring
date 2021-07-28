package com.zemoso.crud.rest;

import com.zemoso.crud.entity.Employee;
import com.zemoso.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRESTController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRESTController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }
    @GetMapping("/employees")
    public List<Employee> getAll(){
        return employeeService.getEmployees();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee theEmployee = employeeService.getById(employeeId);
        if (theEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }
        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {
        theEmployee.setId(0);
        employeeService.save(theEmployee);
        return theEmployee;
    }
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {
        employeeService.save(theEmployee);
        return theEmployee;
    }
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        Employee tempEmployee = employeeService.getById(employeeId);
        if (tempEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }
        employeeService.deleteById(employeeId);
        return "Deleted employee id - " + employeeId;
    }
}

