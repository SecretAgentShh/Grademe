package com.example.studentgrades.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long rollno;
	
	private String name;
	private String course;
	private Date date;

	public Student() {}//JPA may throw error if constructor not included
	
	//Parameterized constructor
	public Student(long rollno, String name,String course, Date date)
	{
		this.rollno = rollno;
		this.name = name;
		this.course = course;
		this.date = date;
	}

public long getRollno() {
	return rollno;
}
public void setRollno(long rollno) {
	this.rollno = rollno;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCourse() {
	return course;
}
public void setCourse(String course) {
	this.course = course;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
}