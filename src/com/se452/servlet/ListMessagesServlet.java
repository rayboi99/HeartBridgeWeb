package com.se452.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.se452.model.*;
import com.se452.service.*;

/**
 * Servlet implementation class ListMessagesServlet
 */
@WebServlet("/ListMessagesServlet")
public class ListMessagesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListMessagesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String userId = request.getParameter("userId");

		MessageService msg = new MessageService();
		List<Message> messageList = msg.listMessagesByUserId(Integer.parseInt(userId));
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");

		for (Message message : messageList)
		{
			out.println("</br></br>");
			out.println("Date: " + message.getDate_Sent() + "</br>");
			out.println("To: " + message.getUser_Id_To().getApp_user_name() + "</br>");
			out.println("From: " + message.getUser_Id_From().getApp_user_name() + "</br>");
			out.println("Subject: " + message.getSubject() + "</br>");
			out.println("Body: " + message.getMessage() + "</br>");
			out.println("</br></br>");
		}		
		
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

}
