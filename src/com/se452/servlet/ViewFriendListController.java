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

import com.se452.model.Friendship;
import com.se452.service.FriendshipServiceDao;

/**
 * Servlet implementation class ViewFriendListController
 */
@WebServlet("/ViewFriendListController")
public class ViewFriendListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager ;
	  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewFriendListController() {
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
		FriendshipServiceDao fssd=new FriendshipServiceDao();
		fssd.setEntityManager(entityManager);
		List<Friendship> fsl=fssd.getFriendShipList(uid);
		session.setAttribute("FriendshipList", fsl);
		response.sendRedirect("ViewFriendshipList.jsp");
	}

}
