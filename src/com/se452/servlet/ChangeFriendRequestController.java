package com.se452.servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.se452.model.FriendRequest;
import com.se452.model.FriendRequestPK;
import com.se452.model.Status;
import com.se452.service.FriendRequestServiceDao;

/**
 * Servlet implementation class ChangeFriendRequestController
 */
@WebServlet("/ChangeFriendRequestController")
public class ChangeFriendRequestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeFriendRequestController() {
        super();
        entityManagerFactory = Persistence.createEntityManagerFactory("SE452EclipseLink2");
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(true);
		int uid=Integer.parseInt(session.getAttribute("userIdKey").toString());
		FriendRequestServiceDao frsd=new FriendRequestServiceDao();
		frsd.setEntityManager(entityManager);
		String SelectedUserAccept=request.getParameter("accept");
		String SelectedUserReject=request.getParameter("reject");
	if(!SelectedUserAccept.isEmpty())
		frsd.changeFriendReqestStatus(uid,Integer.parseInt(SelectedUserAccept), Status.ACCEPT);
	else if(!SelectedUserReject.isEmpty())
		frsd.changeFriendReqestStatus(uid,Integer.parseInt(SelectedUserReject),Status.REJECT);
	List<FriendRequest> frReceivedList =frsd.viewFriendReceivedRequest(uid);
		List<FriendRequest> frSentList =frsd.viewFriendReceivedRequest(uid);
	session.setAttribute("frReceivedList", frReceivedList);
	session.setAttribute("frSentList", frSentList);
	frsd.finalCommit();
	response.sendRedirect("ViewFriendRequest.jsp");
		 
	
		
		
	}

}
