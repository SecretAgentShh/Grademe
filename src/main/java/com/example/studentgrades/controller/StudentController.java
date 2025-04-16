package com.example.studentgrades.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.studentgrades.model.Student;
import com.example.studentgrades.repository.StudentRepo;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	private final StudentRepo stud;
	
	//instantiate the repo
	StudentController(StudentRepo stud)
	{
		this.stud = stud;
	}

	@GetMapping
	public List<Student> getStudents(){
		return stud.findAll();	
	}
	
	@PostMapping("/multiple")
	public List<Student> addStudent(@RequestBody List<Student> newstus )
	{
		return stud.saveAll(newstus);
	}
	
	@PostMapping
	public Student addStudent(@RequestBody Student newstu) {
		return stud.save(newstu);
	
}
}