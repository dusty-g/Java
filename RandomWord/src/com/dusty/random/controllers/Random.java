package com.dusty.random.controllers;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Random
 */
@WebServlet("/Random")
public class Random extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public String generate(){
	    String[] randString = new String[10];
	    for(int i = 0; i < 10; i++){
	      
	      int rand = (int)(Math.random() * (122-97)) + 1+ 97;
	      randString[i] = Character.toString((char) rand);
	    }
	    String joinedString = String.join("", randString);
	    return joinedString;
	  }
    /**
     * @see HttpServlet#HttpServlet()
     */
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		Integer count = (Integer) session.getAttribute("count");
		
		
		if(count == null) {
			session.setAttribute("count", 0);
		}
		
		
		
		
		

		
		request.getRequestDispatcher("/WEB-INF/random.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		HttpSession session = request.getSession();
		session.setAttribute("randomWord", generate());
		
		Integer count = (Integer) session.getAttribute("count");
		
		System.out.println("in post");
		session.setAttribute("count", count+1);
		session.setAttribute("createdAt", new Date());
		doGet(request, response);
	}

}
