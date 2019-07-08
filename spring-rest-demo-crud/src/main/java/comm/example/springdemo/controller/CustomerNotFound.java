package comm.example.springdemo.controller;

@SuppressWarnings("serial")
public class CustomerNotFound extends RuntimeException {

	public CustomerNotFound() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerNotFound(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CustomerNotFound(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CustomerNotFound(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
