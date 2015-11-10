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
import com.se452.model.Status;
import com.se452.service.FriendRequestServiceDao;
import com.se452.service.FriendshipServiceDao;

/**
 * Servlet implementation class CancelFriendshipController
 */
@WebServlet("/CancelFriendshipController")
public class CancelFriendshipController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelFriendshipController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(true);
		int uid=Integer.parseInt(session.getAttribute("userIdKey").toString());
		FriendRequestServiceDao frsd=new FriendRequestServiceDao();
		int friendSelectedId=Integer.parseInt(request.getParameter("cancelButton"));
	
			FriendshipServiceDao fssd=new FriendshipServiceDao();
			fssd.cancelFriendship(uid, friendSelectedId);
			List<Friendship> fsl=(List<Friendship>)fssd.getFriendShipList(uid);
			session.setAttribute("FriendshipList", fsl);
			fssd.finalCommit();
	
	response.sendRedirect("ViewFriendshipList.jsp");
	}

}
