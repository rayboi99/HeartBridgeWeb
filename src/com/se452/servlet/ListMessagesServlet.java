package com.se452.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		HttpSession session = request.getSession(true);
		int uid = Integer.parseInt(session.getAttribute("userIdKey").toString());
		
		MessageService msg = new MessageService();
		List<Message> messageListSent = msg.listMessagesSentByUserId(uid);
		List<Message> messageListReceived = msg.listMessagesReceivedByUserId(uid);
		
		session.setAttribute("messageListSent", messageListSent);
		session.setAttribute("messageListReceived", messageListReceived);
		
		response.sendRedirect("ViewMessages.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		doGet(request, response);
	}
}
