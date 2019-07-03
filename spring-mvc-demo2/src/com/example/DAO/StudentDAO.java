package com.example.DAO;

import java.util.List;

import com.example.spring.Student;

public interface StudentDAO {

	public void addStudent(Student student);

	public List<Student> getAll();

	public void delete(int id);
 
	public void update(Student student); 
}
