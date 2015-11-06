package com.se452.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.se452.model.*;
import com.se452.service.*;


@WebServlet("/ListFriendsServlet")
public class ListFriendsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListFriendsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		HttpSession session = request.getSession(true);
		int uid = Integer.parseInt(session.getAttribute("userIdKey").toString());
		
		FriendshipServiceDao friendService = new FriendshipServiceDao();
		List<Friendship> friendshipList = friendService.getFriendShipList(uid);
		
		request.setAttribute("friendshipList", friendshipList);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AddMessage.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		doGet(request, response);
	}
}
