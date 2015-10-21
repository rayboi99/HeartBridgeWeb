package com.se452.servlet;

import java.io.IOException;
import java.util.ArrayList;
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
import com.se452.service.FriendRequestServiceDao;

/**
 * Servlet implementation class ViewFirendRequestController
 */
@WebServlet("/ViewPendingFriendRequestController")
public class ViewPendingFirendRequestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewPendingFirendRequestController() {
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
		List<FriendRequest> frl=frsd.viewFriendRequest(uid);
		List<FriendRequest> frlN=new ArrayList<FriendRequest>();
		for(int i=0;i<frl.size();i++)
		{
			if(frl.get(i).getRequestStatus().equals("PENDING"))
			{
				frlN.add(frl.get(i));
			}
			
		}
		
		session.setAttribute("FriendRequestList", frlN);
		response.sendRedirect("ChangingAndViewFriendRequest.jsp");
		
	}

}
