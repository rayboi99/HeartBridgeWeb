package com.se452.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.se452.model.AppUser;
import com.se452.model.Profile;
import com.se452.service.UserServiceDao;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterController() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String name = request.getParameter("user_name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		int age = Integer.parseInt(request.getParameter("age"));
		UserServiceDao us = new UserServiceDao();
		String message = "";
		String url = "";

		try {
			if (!us.userNameExists(name)) {
				us.addUser(name, email, gender, password, age);
				AppUser user = us.getUser(name);
				Profile p = new Profile();
				p.setAboutMe("");
				p.setHobby("");
				p.setIdealPartner("");
				p.setPicture(new byte[0]);
				user.setProfile(p);
				
				message ="You are successfully registered. please log in.";
				url ="/Login.jsp";
			} else {
				message = "The username has been used";
				url = "/Register.jsp";
			}

		} catch (NoSuchAlgorithmException e)
		{
			url = "/TechniqueIssue.jsp";
		}
		
		request.setAttribute("message", message);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
		us.closeConnection();
	}
}
