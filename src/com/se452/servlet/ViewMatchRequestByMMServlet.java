package com.se452.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.se452.model.MatchRequest;
import com.se452.service.MatchRequestService;

/**
 * Servlet implementation class ListMatchRequestbyMatchMaker
 */
@WebServlet("/ViewMatchRequestByMMServlet")
public class ViewMatchRequestByMMServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewMatchRequestByMMServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		int uid = Integer.parseInt(session.getAttribute("userIdKey").toString());
		
		MatchRequestService msg = new MatchRequestService();
		List<MatchRequest> matchRequestList = msg.listMatchRequestsbyMatchMakerId(uid);
		
		request.setAttribute("matchRequestList", matchRequestList);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ViewMatchRequestByMM.jsp");
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
