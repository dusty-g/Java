package com.dusty.button.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class buttons
 */
@WebServlet("/test")
public class buttons extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Integer count = (Integer) session.getAttribute("count");
		

		if(count==null) {
			session.setAttribute("count", 0);
		}
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/clicker.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Integer count = (Integer) session.getAttribute("count");
		
		session.setAttribute("count", count+1);
		
		
		doGet(request, response);
	}

}
