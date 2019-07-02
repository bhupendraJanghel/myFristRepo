package comm.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import comm.example.entity.Address;
import comm.example.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private List<Employee> employees = null;

	@PostConstruct
	public void initEmployees() {
		employees = new ArrayList<Employee>();

		employees.add(new Employee("Bhuppi", "janghel", 50000, new Address("Bhilai", "India")));
		employees.add(new Employee("Arindam", "banerjee", 40000, new Address("kolkata", "India")));
		employees.add(new Employee("Hemlata", "patel", 60000, new Address("Indore", "India")));
	}

	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return employees;

	}

	@GetMapping("/employees/{theEmployee}")
	public Employee getEmployee(@PathVariable int theEmployee) {

		if ((theEmployee >= employees.size()) || (theEmployee < 0)) {
			throw new EmployeeNotFoundException("No Such employee found with the id " + theEmployee);
		}
		return employees.get(theEmployee);
	}

	@ExceptionHandler
	public ResponseEntity<EmployeeError> handlerException(EmployeeNotFoundException exc) {

		EmployeeError error = new EmployeeError();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeOccured(System.currentTimeMillis());

		return new ResponseEntity<EmployeeError>(error, HttpStatus.NOT_FOUND);
	}
}
