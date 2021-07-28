package com.zemoso.crud.service;

import com.zemoso.crud.dao.EmployeeDAO;
import com.zemoso.crud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO){
        this.employeeDAO=employeeDAO;
    }
    @Override
    @Transactional
    public List<Employee> getEmployees() {
        return employeeDAO.getEmployees();
    }
    @Override
    @Transactional
    public Employee getById(int id) {
        return employeeDAO.getById(id);
    }
    @Override
    @Transactional
    public void save(Employee employee) {
        employeeDAO.save(employee);
    }
    @Override
    @Transactional
    public void deleteById(int id) {
        employeeDAO.deleteById(id);
    }
}
