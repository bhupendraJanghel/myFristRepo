package com.example.controller;

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

import com.example.model.League;

/**
 * Servlet implementation class AddLeagueServlet
 */
@WebServlet("/add_league.do")
public class AddLeagueServlet extends HttpServlet {

	private int year;
	private String season;
	private String title;
	private List<String> errMsgs = null;

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

		errMsgs = new LinkedList<String>();

		String tempYear = request.getParameter("year");
		try {
			year = Integer.parseInt(tempYear);
		} catch (Exception e) {
			errMsgs.add("Year field can't be non numeric.");
		} 
		season = request.getParameter("season");
		if (season.equals("UNKNOWN")) {
			errMsgs.add("select a league season.");
		}

		title = request.getParameter("title");

		if (title.length() <= 0) {
			errMsgs.add("title field can not be blank");
		}

		if (!errMsgs.isEmpty()) {
			request.setAttribute("ERROR", errMsgs);

			RequestDispatcher view = request.getRequestDispatcher("/add_league.view");
			view.forward(request, response);
		}

		else {
			//request.setAttribute("SUCCESS", new League(year, season, title));
			
			List<League> l=(List<League>)getServletContext().getAttribute("leaguelist");
			l.add(new League(year,season,title));
			RequestDispatcher view = request.getRequestDispatcher("/list_leagues.view");
			view.forward(request, response);
		}

	}

}
