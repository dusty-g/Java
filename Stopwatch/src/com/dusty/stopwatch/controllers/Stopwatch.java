package com.dusty.stopwatch.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dusty.stopwatch.models.Timer;

/**
 * Servlet implementation class Stopwatch
 */
@WebServlet("/Stopwatch")
public class Stopwatch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String urlparam = request.getParameter("action");
		if(urlparam !=null) {
			if(urlparam.equals("reset")) {
				request.getSession().invalidate();
				
			}
		}
		
		HttpSession session = request.getSession();
		Date currentTime = new Date();
		session.setAttribute("currentTime", currentTime);
		System.out.println(session.getAttribute("startTime"));
		if(session.getAttribute("times")==null) {
			session.setAttribute("times", new ArrayList<Timer>());
		}
		if(urlparam !=null) {
			if(urlparam.equals("start")) {
				if(session.getAttribute("startTime")==null) {
					Date start = new Date();
					session.setAttribute("startTime", start);
				}
				
			}else if(urlparam.equals("stop")) {
				if(session.getAttribute("startTime")!=null) {
					Timer newTime = new Timer((Date) session.getAttribute("startTime"), currentTime);
					session.setAttribute("startTime", null);
					session.setAttribute("endTime", null);
					ArrayList<Timer> times = (ArrayList<Timer>) session.getAttribute("times");
					times.add(newTime);
					session.setAttribute("times", times);
				}
			}
		}
		if(session.getAttribute("startTime")!=null) {
			long difference = currentTime.getTime() - ((Date)session.getAttribute("startTime")).getTime();
			session.setAttribute("difference", difference);
		}
		
		
		
		request.getRequestDispatcher("/WEB-INF/views/stopwatch.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}

}
