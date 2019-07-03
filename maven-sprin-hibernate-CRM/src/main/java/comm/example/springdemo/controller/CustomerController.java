package comm.example.springdemo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import comm.example.springdemo.entity.Customer;
import comm.example.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService service;

	@GetMapping("/list")
	public String getAllCustomer(Model theModel) {
		List<Customer> customerList = service.getAllCustomer();
		theModel.addAttribute("customer", customerList);
		return "customer-list";
	}

}
