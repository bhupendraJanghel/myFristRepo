package login_maven.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@Autowired
	private CheckUserDaoImpl dao;

	@RequestMapping("/login")
	public String processLogin(@ModelAttribute("login") Login login) {

		return "Login";

	}

	@RequestMapping("/processForm")
	public String checkUser(@Valid @ModelAttribute("login") Login login, BindingResult bindingResult, Model theModel) {

		if (bindingResult.hasErrors()) {
			return "Login";
		} else {
			Login log = dao.checkUser(login);
			if (log != null) {
				theModel.addAttribute("login", login.getUserName());
				return "process-form";
			} else {
				theModel.addAttribute("error", "User not found");
				return "Login";
			}
		}
	}
}
