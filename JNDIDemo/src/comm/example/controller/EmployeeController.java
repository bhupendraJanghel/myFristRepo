package comm.example.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.example.model.Employee;
import comm.example.service.EmployeeService;
import comm.example.service.EmployeeServiceImpl;

@WebServlet("/controller.do")
public class EmployeeController extends HttpServlet {

	private int eId;
	private String firstName, lastName;
	private int salary;

	private List<String> errlist=null;
	private EmployeeService eService;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		eService = new EmployeeServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		errlist=new LinkedList<String>();
		
		try {
		 eId=Integer.parseInt(req.getParameter("e_id"));
		} catch (Exception e) {
			errlist.add("Id must be number");
			
		}
		
		firstName = req.getParameter("e_fname");
		
		if(firstName.length()<=0)
			errlist.add("first name can not be blank");
		lastName = req.getParameter("e_lname");
		
		String tmpsalary = req.getParameter("e_sal");
		
		try {
			salary=Integer.parseInt(tmpsalary);
		} catch (Exception e) {
			errlist.add("salary must be number.");
		}
		
	
		if(!errlist.isEmpty()) {
		
			req.setAttribute("ERROR",errlist);
			RequestDispatcher view =req.getRequestDispatcher("add_employee.jsp");
			view.forward(req, resp);
		} else {
			Employee employee = new Employee(eId, firstName, lastName, salary);
			eService.createEmployee(employee);
			req.setAttribute("Success",employee);
			RequestDispatcher view=req.getRequestDispatcher("success.jsp");
			view.forward(req, resp);
		}
		
		

	}

}
