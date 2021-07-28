package com.zemoso.restcontollers;

import com.zemoso.entities.Student;
import com.zemoso.errors.StudentNotFoundException;
import com.zemoso.errors.StudentReponseError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.*;

@RestController
@RequestMapping("/api")
public class StudentRESTController {
    private List<Student> students;
    @PostConstruct
    public void loadData(){
        students=new ArrayList<>();
        students.add(new Student("Mary","Smith"));
        students.add(new Student("Krishna","Kumar"));
        students.add(new Student("Vishal","Boney"));
    }
    @GetMapping("/students")
    public List<Student> getStudents(){
            return students;
    }
    @GetMapping("/students/{studentId}")
    public Student getStudentWithID(@PathVariable int studentId){
        if(studentId>students.size()||studentId<0)
            throw new StudentNotFoundException("Student not found with given ID:"+studentId);
        return students.get(studentId);
    }
}
