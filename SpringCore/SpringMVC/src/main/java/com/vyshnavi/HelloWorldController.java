package com.vyshnavi;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
    @RequestMapping("/showForm")
    public String showForm(){
        return "helloWorldForm";
    }
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloWorldView";
    }
    @RequestMapping("/processFormVersionTwo")
    public String processFormToCapitals(HttpServletRequest httpServletRequest, Model model){
        String name=httpServletRequest.getParameter("studentName");
        model.addAttribute("Name",name.toUpperCase());
        return "helloWorldView";
    }
    @RequestMapping("/processFormVersionThree")
    public String processFormToLetters(@RequestParam("studentName") String name, Model model){
        model.addAttribute("Name",name.toLowerCase());
        return "helloWorldView";
    }
}
