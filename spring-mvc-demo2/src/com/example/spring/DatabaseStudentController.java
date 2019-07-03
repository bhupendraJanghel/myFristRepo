package com.example.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.DAO.StudentDAOImpl;

@Controller
@RequestMapping("/database")
public class DatabaseStudentController {

	@Autowired
	private StudentDAOImpl dao;

	@RequestMapping("/showForm")
	public String showPage(Model theModel) {
		Student student = new Student();
		theModel.addAttribute("student", student);
		return "student-form";

	}

	@RequestMapping("/save")
	public String saveStudent(@ModelAttribute("student") Student student) {
		dao.addStudent(student);
		return "redirect:/database/displayAll";
	}

	@RequestMapping("/displayAll")
	public String getAllStudent(Model theModel) {
		List<Student> l = dao.getAll();
		theModel.addAttribute("list", l);
		return "students";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteStudent(@PathVariable int id)
	{
		 dao.delete(id);
		 return "redirect:/database/displayAll";
	}

	@RequestMapping("/update/{id}")
	public String update(@PathVariable int id,@ModelAttribute("student") Student student, Model theModel) {
		theModel.addAttribute("id", id);
		return "updatedForm";
	}
	
	@RequestMapping("/updateStudent")
	public String updateById(@ModelAttribute("student") Student student) {
		dao.update(student);
		return "redirect:/database/displayAll";
	}
}
