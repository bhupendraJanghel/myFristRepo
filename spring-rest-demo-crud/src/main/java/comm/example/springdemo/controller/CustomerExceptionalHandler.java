package comm.example.springdemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerExceptionalHandler {
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFound exc){
		
		CustomerErrorResponse errors=new CustomerErrorResponse(HttpStatus.NOT_FOUND.value(),
				
				exc.getMessage(),System.currentTimeMillis());
				
				return new ResponseEntity<CustomerErrorResponse>(errors,HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException1(Exception e){
		
		CustomerErrorResponse errors=new CustomerErrorResponse(HttpStatus.NOT_FOUND.value(),
				
				e.getMessage(),System.currentTimeMillis());
				
				return new ResponseEntity<CustomerErrorResponse>(errors,HttpStatus.NOT_FOUND);
	}

}
