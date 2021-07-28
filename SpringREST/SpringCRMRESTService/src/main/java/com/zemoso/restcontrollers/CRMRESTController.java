package com.zemoso.restcontrollers;

import com.zemoso.entity.Customer;
import com.zemoso.errors.CustomerNotFoundException;
import com.zemoso.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CRMRESTController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }
    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId){
        return customerService.getCustomers().get(customerId);
    }
    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer){
        customer.setId(0);
        customerService.saveCustomer(customer);
        return customer;
    }
    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer){
        customerService.saveCustomer(customer);
        return customer;
    }
    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId){
        if(customerId>getCustomers().size()|| customerId<0)
            throw new CustomerNotFoundException("Customer Not Found with given ID:"+customerId);
        customerService.deleteCustomer(customerId);
        return "Deleted Customer with ID:"+customerId;
    }
}
