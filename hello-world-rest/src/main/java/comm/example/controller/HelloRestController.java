package comm.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {
	
	@GetMapping("/")             //it is known as end point
	public String sayHello()
	{ 
		return  "hello world...!!!";
		
	}
	

}
