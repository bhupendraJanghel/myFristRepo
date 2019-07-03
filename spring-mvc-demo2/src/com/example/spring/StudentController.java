package com.example.spring;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.DAO.StudentDAO;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentDAO studentDao;

	@RequestMapping("/showForm")
	public String showPage(Model theModel) {
		Student student = new Student();
		theModel.addAttribute("student", student);

		return "student-form";
	}

	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) {

		studentDao.addStudent(student);
		if (bindingResult.hasErrors()) {
			return "student-form";
		} else {
			return "process-form";
		}
	}
	
	@RequestMapping("/save")
	public String saveStudent(@ModelAttribute("student") Student student) {

		return "";
	}

}
