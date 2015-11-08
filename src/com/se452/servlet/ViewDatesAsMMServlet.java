package com.se452.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.se452.model.AppUser;
import com.se452.model.DateInfo;
import com.se452.service.DateInfoService;
import com.se452.service.UserServiceDao;

/**
 * Servlet implementation class ViewDatesAsMMServlet
 */
@WebServlet("/ViewDatesAsMMServlet")
public class ViewDatesAsMMServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewDatesAsMMServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("userIdKey");
		DateInfoService dateService = new DateInfoService();
		List <DateInfo> listOfDates = dateService.ViewDateAsMatchMaker(id);
		request.setAttribute("listOfDates", listOfDates);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ViewDatesAsMM.jsp");
		dispatcher.forward(request, response);
		
		dateService.closeConnection();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String location = (String) request.getAttribute("location");
		String description = (String) request.getAttribute("description");
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("userIdKey");
		
		UserServiceDao userService = new UserServiceDao();
		AppUser user1 = userService.getUser(request.getParameter("user1"));
		AppUser user2 = userService.getUser(request.getParameter("user2"));
		AppUser mm = userService.getUser(id);
		
		DateInfoService dateService = new DateInfoService();
		dateService.createDate(mm, user1, user2, new Date(), location, description);
		
		userService.closeConnection();
		dateService.closeConnection();
	}
}
