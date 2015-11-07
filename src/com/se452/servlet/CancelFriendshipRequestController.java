package com.se452.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.se452.model.Friendship;
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
		int friendId=Integer.parseInt(request.getParameter("cancelButton"));
		FriendshipServiceDao fssd=new FriendshipServiceDao();
		fssd.cancelFriendship(uid, friendId);
		fssd.finalCommit();
		
		FriendshipServiceDao fssd2=new FriendshipServiceDao();
		
		List<Friendship> fsl=fssd2.getFriendShipList(uid);
		fssd2.finalCommit();
		session.setAttribute("FriendshipList", fsl);
		response.sendRedirect("ViewFriendshipList.jsp");
		
	}

}
