package com.example.studentgrades.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.studentgrades.model.Student;

public interface StudentRepo extends JpaRepository<Student, Long>{
	
	List<Student> findById(Long rollno);

}
