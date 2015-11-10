package com.se452.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.se452.model.AppUser;
import com.se452.service.DateInfoService;
import com.se452.service.UserServiceDao;

/**
 * Servlet implementation class SetDateServlet
 */
@WebServlet("/SetDateServlet")
public class SetDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SetDateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user1 = request.getParameter("user1");
		String user2 = request.getParameter("user2");
		String location = request.getParameter("location");
		String description = request.getParameter("description");
		
		
		HttpSession session = request.getSession();
		int mm = (int) session.getAttribute("userIdKey");
		
		UserServiceDao us = new UserServiceDao();
		AppUser matchMaker = us.getUser(mm);
		AppUser usr1 = us.getUser(user1);
		AppUser usr2 = us.getUser(user2);
		us.finalCommit();
		
		DateInfoService ds = new DateInfoService();
		
		//ds.createDate(matchMaker, usr1, usr2, dateTime, location, description);
		
		ds.closeConnection();

	}

}
