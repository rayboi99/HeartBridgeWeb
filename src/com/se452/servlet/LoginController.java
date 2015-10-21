package com.se452.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.se452.service.UserServiceDao;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        entityManagerFactory = Persistence.createEntityManagerFactory("SE452EclipseLink2");
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
    
    }


	/**
	 * @param user_Id 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(true);
		String name = request.getParameter("user_name");
		String password=request.getParameter("password");
		UserServiceDao us=new UserServiceDao();
		us.setEntityManager(entityManager);
		int userId=us.getUser(name).getApp_user_id();
		session.setAttribute("userIdKey", userId);
		us.setEntityManager(entityManager);
		try {
			boolean ifRight=us.verifyExistingUser(name, password);
			if(ifRight==true)
			{
				PrintWriter out = response.getWriter(  ); 
			     response.setContentType("text/html"); 
			     out.println("<H1>"+name+"</h2>"); 
			     out.println("<H1>You are successfully Login. Welcome!</h2>"); 
			     response.sendRedirect("functionList.jsp");
			}
			else if (ifRight==false)
			{
				response.sendRedirect("LoginAgain.jsp");
			}
		} catch (NoSuchAlgorithmException e) {
			
			response.sendRedirect("TechniqueIssue.jsp");
		}
		
	}

}
