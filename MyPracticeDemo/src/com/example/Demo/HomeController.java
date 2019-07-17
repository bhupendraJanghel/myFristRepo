package com.example.Demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("home")
public class HomeController {

	
	@RequestMapping("/showPage")
	public String showPage()
	{ 
		return "main-page";
	}
	
	@RequestMapping("/showForm")
	public String showForm()
	{ 
		return "show-form";
	}
	
	/*
	 * @RequestMapping("/processForm") public String processForm(HttpServletRequest
	 * req,Model model) {
	 * 
	 * String fname=req.getParameter("firstName"); String
	 * lname=req.getParameter("lastName"); System.out.println(fname);
	 * System.out.println(lname); String
	 * result="Hello,"+fname.toUpperCase()+" "+lname.toUpperCase()
	 * +", Good Morning.... ";
	 * 
	 * model.addAttribute("message",result); return "process-form"; }
	 */
	
	@RequestMapping("/processForm")
	public String processFormversion2(@RequestParam("firstName") String fname,@RequestParam("lastName")String lname, Model model)
	{ 
		String result=fname.toUpperCase()+" "+lname.toUpperCase();
		
		model.addAttribute("message", result);
		
		return "process-form";
	}
}
