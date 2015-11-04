package com.se452.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.se452.model.MatchType;
import com.se452.model.Status;
import com.se452.service.MatchRequestService;

/**
 * Servlet implementation class AddMatchRequestServlet
 */
@WebServlet("/AddMatchRequestAsUserServlet")
public class AddMatchRequestAsUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMatchRequestAsUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		
		String matchMakerId = request.getParameter("MatchMakerId");
		String user1Id = session.getAttribute("userIdKey").toString();
		String user2Id = request.getParameter("User2Id");
		String RequestType = MatchType.UMU.toString();
		String RequestStatus = Status.PENDING.toString();

		MatchRequestService msg = new MatchRequestService();
		try {
			msg.addMatchRequest(Integer.parseInt(matchMakerId), Integer.parseInt(user1Id), Integer.parseInt(user2Id), new Date(), null, RequestStatus, RequestType, null, null);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("MatchRequest has been added successfully!");		
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
