package com.se452.servlet;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class ViewFriendRequestController
 */
@WebServlet("/ViewFriendRequestController")
public class ViewFriendRequestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewFriendRequestController() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session=request.getSession(true);
    			
    			int uid=Integer.parseInt(session.getAttribute("userIdKey").toString());
    			FriendRequestServiceDao frsd=new FriendRequestServiceDao();
    			List<FriendRequest> frReceivedList =frsd.viewFriendReceivedRequest(uid);
    	 		List<FriendRequest> frSentList =frsd.viewFriendReceivedRequest(uid);
    			session.setAttribute("frReceivedList", frReceivedList);
    			session.setAttribute("frSentList", frSentList);
    			frsd.finalCommit();
    			response.sendRedirect("ViewFriendRequest.jsp");
    			
    		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
HttpSession session=request.getSession(true);
		
		int uid=Integer.parseInt(session.getAttribute("userIdKey").toString());
		FriendRequestServiceDao frsd=new FriendRequestServiceDao();
		List<FriendRequest> frReceivedList =frsd.viewFriendReceivedRequest(uid);
		List<FriendRequest> pendingReceived = new ArrayList<>();
		List<FriendRequest> acceptReceived = new ArrayList<>();
		List<FriendRequest> rejectReceived = new ArrayList<>();
		for(int i=0;i<frReceivedList.size();i++)
		{
			if(frReceivedList.get(i).getRequestStatus().equals("PENDING")){
				pendingReceived.add(frReceivedList.get(i));
			}
			if(frReceivedList.get(i).getRequestStatus().equals("ACCEPT")){
				acceptReceived.add(frReceivedList.get(i));
			}
			if(frReceivedList.get(i).getRequestStatus().equals("REJECT")){
				rejectReceived.add(frReceivedList.get(i));
			}
		}
		
 		List<FriendRequest> frSentList =frsd.viewFriendReceivedRequest(uid);
 		List<FriendRequest> acceptSent = new ArrayList<>();
		List<FriendRequest> rejectSent= new ArrayList<>();
		List<FriendRequest> pendingSent= new ArrayList<>();
		for(int i=0;i<frSentList.size();i++)
		{
			if(frSentList.get(i).getRequestStatus().equals("PENDING")){
				pendingSent.add(frSentList.get(i));
			}
			if(frSentList.get(i).getRequestStatus().equals("ACCEPT")){
				acceptSent.add(frSentList.get(i));
			}
			if(frSentList.get(i).getRequestStatus().equals("REJECT")){
				rejectSent.add(frSentList.get(i));
			}
		}
		session.setAttribute("pendingReceived", pendingReceived);
		session.setAttribute("acceptReceived", acceptReceived);
		session.setAttribute("rejectReceived", rejectReceived);
		session.setAttribute("acceptSent", acceptSent);
		session.setAttribute("rejectSent", rejectSent);
		session.setAttribute("pendingSent", pendingSent);
		session.setAttribute("frReceivedList", frReceivedList);
		session.setAttribute("frSentList", frSentList);
		response.sendRedirect("ViewFriendRequest.jsp");
		
	}

}
