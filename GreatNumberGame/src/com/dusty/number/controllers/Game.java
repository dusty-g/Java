package com.dusty.number.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Game
 */
@WebServlet("/Game")
public class Game extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Game() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Integer randomNumber = (int)(Math.random() * 99) + 1;
		if(session.getAttribute("gameOver") == null) {
			session.setAttribute("gameOver", false);
			session.setAttribute("randomNumber", randomNumber);
			session.setAttribute("hasGuessed", false);
			session.setAttribute("tooHigh", false);
		}
		
		
		
		request.getRequestDispatcher("/game.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("guess")!=null) {
			Integer guess = Integer.parseInt(request.getParameter("guess"));
			Integer randomNumber = (Integer) request.getSession().getAttribute("randomNumber");
			if(randomNumber == guess) {
				request.getSession().setAttribute("gameOver", true);
			}else if(randomNumber > guess) {
				request.getSession().setAttribute("tooHigh", false);
			}else {
				request.getSession().setAttribute("tooHigh", true);
			}
			request.getSession().setAttribute("hasGuessed", true);
		}
		if(request.getParameter("reset") != null) {
			request.getSession().invalidate();
		}
		doGet(request, response);
	}

}
