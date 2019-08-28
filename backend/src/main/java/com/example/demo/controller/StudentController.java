package com.example.demo.controller;



import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author bhumika
 */
@CrossOrigin(allowedHeaders = "*" , origins = "*")
@RestController
@RequestMapping("/students")
public class StudentController {
    
    @Autowired
    private StudentService studentService;
    @RequestMapping(value="/student", method = RequestMethod.GET)
    public List<Student> listUser(){
        return studentService.findAll();
    }

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public Student create(@RequestBody Student student){
        return studentService.save(student);
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable(value = "id") Long id){
        studentService.delete(id);
        return "success";
    }
    
}
