package com.se452.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.se452.model.FriendRequest;
import com.se452.model.Friendship;
import com.se452.service.FriendRequestServiceDao;
import com.se452.service.FriendshipServiceDao;

/**
 * Servlet implementation class CancelFriendshipRequestController
 */
@WebServlet("/CancelFriendshipRequestController")
public class CancelFriendshipRequestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelFriendshipRequestController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
HttpSession session=request.getSession(true);
		int uid=Integer.parseInt(session.getAttribute("userIdKey").toString());
		int friendId=Integer.parseInt(request.getParameter("changeStatus"));
		FriendRequestServiceDao fssd=new FriendRequestServiceDao();
		fssd.cancelFriendRequest(uid, friendId);
	
		List<FriendRequest> frReceivedList =fssd.viewFriendReceivedRequest(uid);
		List<FriendRequest> frSentList =fssd.viewFriendSentRequest(uid);
	session.setAttribute("frReceivedList", frReceivedList);
	session.setAttribute("frSentList", frSentList);
	fssd.finalCommit();
	response.sendRedirect("ViewFriendRequest.jsp");
	
		
		
	}

}
