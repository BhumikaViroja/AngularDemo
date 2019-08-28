package com.example.demo.service;


import com.example.demo.dao.StudentDao;
import com.example.demo.model.Student;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

/**
 *
 * @author bhumika
 */
@Service
public class StudentService {
    
     private StudentDao studentDao;

    @Autowired
    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
    
    public Student save(Student student) {
        return studentDao.save(student);
    }

    
    public List<Student> findAll() {
        List<Student> list = new ArrayList<>();
		studentDao.findAll().iterator().forEachRemaining(list::add);
		return list;
    }

    
    public void delete(Long student) {
        
        Student s= studentDao.getOne(student);
        studentDao.delete(s);
    }
    
}
