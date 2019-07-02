package com.example.service;

import java.util.List;

import com.example.dao.StudentDao;
import com.example.dao.StudentDaoImpl;
import com.example.demo.Student;

public class StudentServiceImpl implements StudentService{

	private StudentDao dao;

	public StudentServiceImpl() {
		super();
		dao = new StudentDaoImpl();
	}

	@Override
	public void createStudent(Student student) {
		dao.createStudent(student);
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return dao.getAllStudent();
	}

	@Override
	public Student getStudentById(int id) {
		
		return dao.getStudentById(id);
	}

	@Override
	public List<Student> getStudentByName(String name) {
		// TODO Auto-generated method stub
		return dao.getStudentByName(name);
	}

	@Override
	public void deleteById(int id) {
		dao.deleteById(id);
		
	}

	@Override
	public void update(int id) {
		dao.update(id);
	}

	/*
	 * public StudentServiceImpl() { super(); dao = new StudentDao() {
	 * 
	 * @Override public List<Student> getAllStudent() {
	 * 
	 * return dao.getAllStudent(); }
	 * 
	 * @Override public void createStudent(Student student) {
	 * dao.createStudent(student);
	 * 
	 * } }; }
	 */
}
