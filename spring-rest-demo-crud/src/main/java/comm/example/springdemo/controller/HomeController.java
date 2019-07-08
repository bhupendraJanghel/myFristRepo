package comm.example.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import comm.example.springdemo.entity.Customer;
import comm.example.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class HomeController {

	@Autowired
	private CustomerService service;

	@PostMapping("/customers")
	public ResponseEntity<?> createCustomer(@RequestBody Customer customer) {

		customer.setId(0);
		service.createCustomer(customer);
		return ResponseEntity.ok().body("Cusomter added successfully.");
	}

	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomer() {
		List<Customer> customers=service.getAllCustomer();
	    return ResponseEntity.ok().body(customers);
	}

	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable int id) {
		Customer customer = service.getCustomerById(id);
		if (customer == null)
			throw new CustomerNotFound("Customer with Id:" + id + " not found");
		else
			return ResponseEntity.ok().body(customer);
		}

	@DeleteMapping("/customers/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable int id) {
		service.deleteCustomer(id);
		return ResponseEntity.ok().body("Customer deleted successfully");
	}

	@PutMapping("/customers")
	public  ResponseEntity<?> updateCustomer(@RequestBody Customer customer) {
		
		service.createCustomer(customer);
		return ResponseEntity.ok().body("Updates successfully...");
		
	}

}
