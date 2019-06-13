package com.example.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.League;

/**
 * Servlet implementation class SuccessServlet
 */
@WebServlet("/successpage.view")
public class SuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		League l = (League) request.getAttribute("SUCCESS");
		
		out.print("<html><body><h2 style='color:green'>Successfully Added</h2><table><tr><th>Title</th><th>Season</th><th>Year</th></tr>");
		out.println("<tr><td>" + l.getTitle() + "</td><td>" + l.getSeason() + "</td><td>" + l.getYear()+"</td></tr></table>");
		
		
		out.println("<a href='add_league.view'>Back to home</a>");
		
		out.println("</body></html>");
	}

}
