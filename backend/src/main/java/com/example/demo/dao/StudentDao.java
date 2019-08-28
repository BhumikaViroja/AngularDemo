package com.example.demo.dao;

import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bhumika
 */
@Repository
public interface StudentDao extends JpaRepository<Student,Long>{
    
    

}
