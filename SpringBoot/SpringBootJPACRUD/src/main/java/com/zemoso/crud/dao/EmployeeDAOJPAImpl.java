package com.zemoso.crud.dao;

import com.zemoso.crud.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO {
     private EntityManager entityManager;
     @Autowired
     public EmployeeDAOJPAImpl(EntityManager entityManager){
         this.entityManager=entityManager;
     }

     @Override
    public List<Employee> getEmployees(){
         Query<Employee> query= (Query<Employee>) entityManager.createQuery("from Employee");
        List<Employee> employees=query.getResultList();
        return employees;
    }
    @Override
    public Employee getById(int id) {
        Employee employee=entityManager.find(Employee.class,id);
        return employee;
    }
    @Override
    public void save(Employee theEmployee) {
        Employee employee=entityManager.merge(theEmployee);
        theEmployee.setId(employee.getId());
    }
    @Override
    public void deleteById(int theId) {
        javax.persistence.Query query=entityManager.createQuery("delete from Employee where id=:empId");
        query.setParameter("empId",theId);
        query.executeUpdate();
    }

}
