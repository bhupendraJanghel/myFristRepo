package comm.example.springdemo.controller;

public class CustomerErrorResponse {


	private int status;
	private String message;
	private long timeOccured;
	
	public CustomerErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerErrorResponse(int status, String message, long timeOccured) {
		super();
		this.status = status;
		this.message = message;
		this.timeOccured = timeOccured;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimeOccured() {
		return timeOccured;
	}

	public void setTimeOccured(long timeOccured) {
		this.timeOccured = timeOccured;
	}
	
}
