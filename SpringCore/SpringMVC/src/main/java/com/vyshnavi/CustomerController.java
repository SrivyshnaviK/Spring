package com.vyshnavi;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }
    @RequestMapping("/showForm")
    public String showForm(Model model){
        model.addAttribute("Customer",new Customer());
        return "customerForm";
    }
    @RequestMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("Customer") Customer customer, BindingResult bindingResult){
        System.out.println("The Binding Result:"+bindingResult);
        if(bindingResult.hasErrors())
            return "customerForm";
        else
            return "customerConfirmation";
    }
}
