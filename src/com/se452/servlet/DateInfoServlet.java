package com.se452.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.se452.model.AppUser;
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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usr1 = request.getParameter("user1");
		String usr2 = request.getParameter("user2");
		String location = request.getParameter("location");
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String description = request.getParameter ("description");
		
		SimpleDateFormat format = new SimpleDateFormat ("MMMM dd, yyyy hh:mm");
		
		java.util.Date dateTime = null;
		try {
			dateTime = format.parse(date+" "+time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		AppUser user1 = new AppUser ();
		user1.setApp_user_id(3);
		user1.setApp_user_name(usr1);
		
		AppUser user2 = new AppUser();
		user2.setApp_user_id(2);
		user2.setApp_user_name(usr2);
		
		AppUser mm = new AppUser();
		mm.setApp_user_id(4);
		user2.setApp_user_name("Rey");
		
		DateInfoService dateInfo = new DateInfoService ();
		dateInfo.createDate(mm,user1, user2, dateTime, location, description);
		
		PrintWriter out = response.getWriter();
		
		out.println ("<html>");
		out.println("Hello, success!");
		out.println ("</html>");

	}
}
