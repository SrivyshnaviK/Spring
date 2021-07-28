package com.vyshnavi.DAO;

import com.vyshnavi.entities.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public class CustomerDAOImpl implements CustomerDAO{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Customer> getCustomers() {
        Session session=sessionFactory.getCurrentSession();
        Query<Customer> query=session.createQuery("from Customer" +
                " order by firstName",Customer.class);
        return query.getResultList();
    }
    @Override
    public void saveCustomer(Customer customer) {
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(customer);
    }
    @Override
    public Customer getCustomer(int id) {
        Session session=sessionFactory.getCurrentSession();
        return session.get(Customer.class,id);
    }
    @Override
    public void deleteCustomer(int id) {
        Session session=sessionFactory.getCurrentSession();
        session.delete(session.get(Customer.class,id));
    }
}
