package com.example.springbootRestEmployee.controller;

public class EmployeeErrorResponse {

	private int status;
	private String message;
	private double time;

	public EmployeeErrorResponse(int status, String message, double time) {
		super();
		this.status = status;
		this.message = message;
		this.time = time;
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

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

}
