package com.se452.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.se452.model.MatchRequest;
import com.se452.model.Status;
import com.se452.service.MatchRequestService;

/**
 * Servlet implementation class UpdateMatchRequestServlet
 */
@WebServlet("/UpdateMatchRequestServlet")
public class UpdateMatchRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMatchRequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String matchMakerId = request.getParameter("MatchMakerId");
		String user1Id = request.getParameter("User1Id");
		String user2Id = request.getParameter("User2Id");
		String user1RequestStatus = request.getParameter("user1RequestStatus");
		String user2RequestStatus = request.getParameter("user2RequestStatus");
		
		MatchRequestService msg = new MatchRequestService();
		try {
			msg.updateMatchRequestStatus(Integer.parseInt(matchMakerId), Integer.parseInt(user1Id), Integer.parseInt(user2Id), user1RequestStatus, user2RequestStatus);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ViewMatchRequestByUserServlet");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
