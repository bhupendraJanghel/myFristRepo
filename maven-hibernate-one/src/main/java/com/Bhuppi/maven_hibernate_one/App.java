package com.Bhuppi.maven_hibernate_one;

import static java.lang.System.out;
import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.Bhuppi.maven_hibernate_one.service.StudentServiceImple;

public class App {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		StudentServiceImple service = new StudentServiceImple();
		int choice = 0;
		try {
			do {
				out.println("1. Insert");
				out.println("2. Display ALL");
				out.println("3. Get by Id");
				out.println("4. Get by Name");
				out.println("5. Delete by Id");
				out.println("6. Update by Id");
				out.println("0.Exit");
				choice = sc.nextInt();

				switch (choice) {
				case 1:
					out.println("First Name:");
					String fName = sc.next();
					out.println("Last Name");
					String lName = sc.next();
					out.println("Email");
					String email = sc.next();

					service.createStudent(new Student(fName, lName, email));
					out.print("Success...!");
					break;
				case 2:
					List<Student> list = service.getAllStudent();
					for (Student s : list) {
						out.println(s);
					}
					break;
				case 3:
					out.println("ID to search:");
					int id = sc.nextInt();
					Student s = service.getStudentById(id);
					if (s != null)
						out.println("Found :" + s);
					else
						out.println("Id is not Found");
					break;
				case 4:
					out.println("Name to search:");
					String Name = sc.next();
					List<Student> ls = service.getStudentByName(Name);
					if (ls != null) {
						for (Student student : ls) {
							out.println(student);
						}
					} else
						out.println("Name is not Found");
					break;
				case 5:
					out.print("Id to Delete:");
					int deleteId = sc.nextInt();
					
						
						service.deleteById(deleteId);
						System.out.println("Delete successfully");
					break;
				case 6:
					out.println("Id to  Update:");
					id=sc.nextInt();
					service.update(id);

				default:
					break;
				}

			} while (choice != 0);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
