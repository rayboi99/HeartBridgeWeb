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

import com.se452.service.*;
import com.se452.model.*;

/**
 * Servlet implementation class ViewUniversityListController
 */
@WebServlet("/ViewUniversityListController")
public class ViewUniversityListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager ;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewUniversityListController() {
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
		UserUniversityServiceDao uusd=new  UserUniversityServiceDao();
		uusd.setEntityManager(entityManager);
		List<University> list=uusd.showUserUniversityList(uid);
		session.setAttribute("UUlist", list);
		response.sendRedirect("UserUniversityList.jsp");
		//entityManager.close();
	}

}
