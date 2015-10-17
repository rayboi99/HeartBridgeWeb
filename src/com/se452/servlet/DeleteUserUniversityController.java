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

import com.se452.University.University;
import com.se452.University.UserUniversityServiceDao;

/**
 * Servlet implementation class DeleteUserUniversity
 */
@WebServlet("/DeleteUniversityController")
public class DeleteUserUniversityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserUniversityController() {
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
		String uis=session.getAttribute("userIdKey").toString();
		int uid=Integer.parseInt(uis);
		int unid=Integer.parseInt(request.getParameter("chosenUniversity"));
		UserUniversityServiceDao uusd=new UserUniversityServiceDao();
		uusd.setEntityManager(entityManager); 
		uusd.deleteUserUniversity(uid, unid);
		response.sendRedirect("functionList.jsp");
	}

}
