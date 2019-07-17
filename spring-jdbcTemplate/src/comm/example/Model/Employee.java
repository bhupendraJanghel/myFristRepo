package comm.example.Model;

import java.io.Serializable;

public class Employee implements Serializable {

	private int employeeId;
	private String firstName;
	private String lastName;
	private int salary;

	public Employee() {
		super();

	}

	public Employee(int employeeId, String firstName, String lastName, int salary) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("\nEmployee Id: ").append(employeeId);
		sb.append("\nFirst Name: ").append(firstName);
		sb.append("\nLast Name: ").append(lastName);
		sb.append("\nSalary: ").append(salary);	
		sb.append("\n-------------------------------------------------------");
		
		return sb.toString();
	}

	
}
