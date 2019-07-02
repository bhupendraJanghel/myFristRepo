package com.Bhuppi.maven_hibernate_one.dao;

import java.util.List;

import com.Bhuppi.maven_hibernate_one.Student;

public interface StudentDao {
	public void createStudent(Student student);

	public List<Student> getAllStudent();

	public Student getStudentById(int id);

	public void deleteById(int id);

	public List<Student> getStudentByName(String Name);

	public void update(int id);
}
