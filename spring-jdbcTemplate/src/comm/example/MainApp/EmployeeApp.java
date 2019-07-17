package comm.example.MainApp;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import comm.example.DAO.EmpDAO;
import comm.example.Model.Employee;
import comm.example.service.EmployeeService;
import comm.example.service.EmployeeServiceImpl;

public class EmployeeApp {

	static Scanner sc = new Scanner(System.in);

	private EmployeeService service=new EmployeeServiceImpl();
	public static void main(String arg[]) {

		int choice = 0;
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EmployeeConfig.class);
		EmployeeService emp = context.getBean("dao", EmployeeServiceImpl.class);
		
		do {
			System.out.println("1. Add Employee.");
			System.out.println("2. Find employee by id.");
			System.out.println("3. Display all employee.");
			System.out.println("4. Update Employee by Id.");
			System.out.println("5. Find employee by Name.");
			System.out.println("6. Delete by Id.");
			System.out.println("7. Exit.");
			System.out.println("Input your choice");
			choice = sc.nextInt();
			switch (choice) {
			case 1:

				System.out.print("ID:");
				int id = sc.nextInt();
				System.out.print("First name:");
				String firstName = sc.next();
				System.out.print("Last name:");
				String lastName = sc.next();
				System.out.print("Salary:");
				int salary = sc.nextInt();

				emp.addEmployee(new Employee(id, firstName, lastName, salary));
				System.out.println("employee added successfully..!!");
				break;
			case 2:
				System.out.println("Enter Employee ID:");
				int empid = sc.nextInt();
				try {
					Employee emp1 = emp.findByID(empid);

					System.out.println(emp1.toString());
				} catch (Exception e) {
					System.out.println("No such Id found..!!!");
				}
				break;
			case 3:
				List<Employee> ls = emp.getAllEmployee();

				for (Employee e : ls) {
					System.out.println(e);
				}
				break;
			case 4:
				System.out.println("Enter Employee ID:");
				int empid1 = sc.nextInt();
				try {
					emp.findByID(empid1);

					System.out.println(emp.updateEmployee(empid1));

				} catch (Exception e) {
					System.out.println("No such Id found..!!!");
				}
				break;
			case 5:
				System.out.println("Enter First name:");
				firstName=sc.next();
				List<Employee> ls1=emp.findByName(firstName);
				for(Employee e:ls1)
				{
					System.out.println(e.toString());
				}
				
			case 6:
				System.exit(0);
			default:

				break;
			}
		} while (choice != 0);

	}

}
