package com.Bhuppi.maven_hibernate_one.service;

import java.util.List;

import com.Bhuppi.maven_hibernate_one.Student;

public interface StudentService {

	public void createStudent(Student student);

	public List<Student> getAllStudent();

	public Student getStudentById(int id);

	public List<Student> getStudentByName(String name);

	public void deleteById(int id);
	public void update(int id);
}
