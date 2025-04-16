package com.example.studentgrades.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.studentgrades.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long>{
	//List<Student> findByRollno(Long rollno);

}
