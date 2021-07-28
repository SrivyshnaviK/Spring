package com.zemoso.crud.dao;

import com.zemoso.crud.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getEmployees();
    Employee getById(int theId);
    void save(Employee theEmployee);
    void deleteById(int theId);
}
