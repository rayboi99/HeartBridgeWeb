package com.se452.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

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
			// I'm going to default to use ACCEPT for now
			msg.updateMatchRequestStatus(Integer.parseInt(matchMakerId), Integer.parseInt(user1Id), Integer.parseInt(user2Id), Status.ACCEPT, Status.ACCEPT);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<MatchRequest> matchRequestList = msg.listMatchRequestsbyMatchMakerId(Integer.parseInt(matchMakerId));
		
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>MatchRequest Info after Update</h1>");

		for (MatchRequest matchRequest : matchRequestList)
		{
			out.println("</br></br>");
			out.println("Date: " + matchRequest.getRequest_Time() + "</br>");
			out.println("MatchMaker: " + matchRequest.getMatchMaker_Id().getUserName() + "</br>");
			out.println("User1: " + matchRequest.getUser1_Id().getUserName() + "</br>");
			out.println("User1Status: " + matchRequest.getUser1_Request_Status() + "</br>");
			out.println("User2: " + matchRequest.getUser2_Id().getUserName() + "</br>");
			out.println("User2Status: " + matchRequest.getUser2_Request_Status() + "</br>");
			out.println("MatchRequestStatus: " + matchRequest.getRequest_Status() + "</br>");
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
