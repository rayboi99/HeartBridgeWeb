package com.se452.servlet;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.se452.model.AppUser;
import com.se452.model.DateInfo;
import com.se452.service.DateInfoService;

/**
 * Servlet implementation class DateInfoServlet
 */

public class DateInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DateInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("create") != null){
			goToPage("/CreateDate.html",request,response);
			}
		else{
			DateInfoService dateService = new DateInfoService();
			List<DateInfo> listOfDates = new ArrayList <DateInfo>();
			listOfDates=dateService.ViewDateAsMatchMaker(1);
			request.setAttribute("listOfDates", listOfDates);
			goToPage("/ViewAsMatchMaker.jsp",request,response);
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usr1 = request.getParameter("user1");
		String usr2 = request.getParameter("user2");
		String location = request.getParameter("location");
		String date = request.getParameter("date");
		String month = request.getParameter("month");
		String year = request.getParameter("year");
		String hour = request.getParameter("hour");
		String minute = request.getParameter("minute");
		String description = request.getParameter ("description");
		
		
		StringBuilder sb = new StringBuilder ();
		sb.append(date);
		sb.append("-");
		sb.append(month);
		sb.append("-");
		sb.append(year);
		sb.append(" ");
		sb.append(hour);
		sb.append(":");
		sb.append(minute);
		sb.append(":00");
		
		
		SimpleDateFormat format = new SimpleDateFormat ("dd-MM-yyyy HH:mm:ss");
		
		java.util.Date dateTime = new Date();
		try {
			dateTime = format.parse(sb.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		AppUser user1 = new AppUser ();
		user1.setApp_user_id(2);
		user1.setApp_user_name(usr1);
		
		AppUser user2 = new AppUser();
		user2.setApp_user_id(3);
		user2.setApp_user_name(usr2);
		
		AppUser mm = new AppUser();
		mm.setApp_user_id(1);
		user2.setApp_user_name("Rey");
		
		DateInfoService dateInfo = new DateInfoService ();
		dateInfo.createDate(mm,user1, user2, dateTime, location, description);
		
		goToPage("/SuccessCreatingADate.html",request,response);

	}
	
	private void goToPage (String address, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}
	
	
	
}
