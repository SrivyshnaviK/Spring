package com.vyshnavi.controller;

import com.vyshnavi.DAO.CustomerDAO;
import com.vyshnavi.entities.Customer;
import com.vyshnavi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping("/list")
    public String listCustomers(Model model){
        model.addAttribute("customers",customerService.getCustomers());
        return "listCustomers";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        Customer customer=new Customer();
        model.addAttribute("customer",customer);
        return "customerForm";
    }
    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer){
        customerService.saveCustomer(customer);
        return "redirect:/customer/list";
    }
    @GetMapping("showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int id,Model model){
        Customer customer=customerService.getCustomer(id);
        model.addAttribute("customer",customer);
        return "customerForm";
    }
    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int id){
        customerService.deleteCustomer(id);
        return "redirect:/customer/list";

    }
}
