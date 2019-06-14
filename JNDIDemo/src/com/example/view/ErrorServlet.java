package com.example.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ErrorServlet
 */
@WebServlet("/error.view")
public class ErrorServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	
    	response.setContentType("text/html");
    	PrintWriter out=response.getWriter();
    	
    	List<String> errList=(List<String>)request.getAttribute("ERROR");
    	
    	out.println("<body style='color:red'>");
    	for(String str:errList)
    	{
    		out.println(str+"<br/>");
    	}
    	out.println("<a href='add_employee.html'>Back to home</a>");
		out.println("</body>");
	}

}
