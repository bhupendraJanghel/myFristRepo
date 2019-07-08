package comm.example.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import comm.example.springdemo.dao.CustomerDao;
import comm.example.springdemo.entity.Customer;
import comm.example.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService service;

	@RequestMapping("/list")
	public String getAllCustomer(Model theModel) {
		List<Customer> customerList = service.getAllCustomer();
		theModel.addAttribute("customer", customerList);
		return "customer-list";
	}
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		Customer customer=new Customer();
		theModel.addAttribute("customerModel", customer);		
		return "customer-form";
	}

	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("customerModel") Customer customer)
	{
		service.createCustomer(customer);
		return "redirect:/customer/list";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteCustomer(@PathVariable("id")int id)
	{ 
		try {
			System.out.println("start");
		service.deleteCustomer(id);
		System.out.println("end");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "redirect:/customer/list";
	}
	
	@RequestMapping("/update/{customer.id}")
	public String updateCustomer(@PathVariable Customer customer)
	{
		System.out.println("customer=====" + customer.toString());
//		Customer customer=service.updateCustomer(id);
		
		return "redirect:/customer/list";
	}
}
