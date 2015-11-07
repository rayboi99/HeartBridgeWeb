package com.se452.servlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.se452.service.FriendRequestServiceDao;

/**
 * Servlet implementation class MakeFriendRequestController
 */
@WebServlet("/MakeFriendRequestController")
public class MakeFriendRequestController extends HttpServlet {
	private static final long serialVersionUID = 1L;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakeFriendRequestController() {
        super();
       
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(true);
		String uis=session.getAttribute("userIdKey").toString();
		int chooseUser=(int)session.getAttribute("selectedId");
		int uid=Integer.parseInt(uis);
		if(uid==chooseUser)
		{
			request.setAttribute("FriendRequest", "Can not make the request.");
			request.getRequestDispatcher("ViewOtherUserProfile.jsp").forward(request, response);
		}
		else{
		//int userId=Integer.parseInt(request.getParameter("chosenUser"));
		FriendRequestServiceDao frsd=new FriendRequestServiceDao();
		try{
		frsd.sendFriendRequest(uid, chooseUser);
		frsd.finalCommit();
		request.setAttribute("FriendRequest", "Send Request, please waiting for response.");
		request.getRequestDispatcher("ViewOtherUserProfile.jsp").forward(request, response);
		}
		catch(Exception e){
			request.setAttribute("FriendRequest", "You can only try one time to add a user as friend.");
			request.getRequestDispatcher("ViewOtherUserProfile.jsp").forward(request, response);

		}
		}
		
	}

}
