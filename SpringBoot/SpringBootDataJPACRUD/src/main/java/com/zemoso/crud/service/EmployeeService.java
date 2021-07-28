package com.zemoso.crud.service;

import com.zemoso.crud.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();
    Employee getById(int id);
    void save(Employee employee);
    void deleteById(int id);
}
