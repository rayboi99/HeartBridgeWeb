package com.se452.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.se452.service.*;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        entityManagerFactory = Persistence.createEntityManagerFactory("SE452EclipseLink2");
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
        
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("user_name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String gender=request.getParameter("gender");
		int age=Integer.parseInt(request.getParameter("age"));
		UserServiceDao us=new UserServiceDao();
		us.setEntityManager(entityManager);
		try {
			
			boolean ifUserNameAlreadyExist=us.CheckIfUserNameExist(name);
			if(ifUserNameAlreadyExist==false){
				us.addUser(name, email, gender, password, age);
				entityManager.getTransaction().commit();
			PrintWriter out = response.getWriter(  ); 
		     response.setContentType("text/html"); 
		     out.println("<H1>You are successfully registered. Welcome!</h2>"); 
		     response.sendRedirect("Login.jsp");
			}
			else if(ifUserNameAlreadyExist==true)
			{
				response.sendRedirect("RegisterAgain.jsp");
			}
			//appUserService.commitTransaction();
		} catch (NoSuchAlgorithmException e) {
			response.sendRedirect("TechniqueIssue.jsp");
		}
		
		entityManager.close();

	}

}
