package com.vyshnavi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
    @RequestMapping("/showForm")
    public String showStudentForm(Model model){
        Student student=new Student();
        model.addAttribute("Student",student);
        return "studentForm";
    }
    @RequestMapping("/processForm")
    public String processStudentForm(@ModelAttribute("Student") Student student){
        System.out.println("Student data:"+student.getFirstName()+" "+student.getLastName());
        return "studentConfirmation";
    }
}
