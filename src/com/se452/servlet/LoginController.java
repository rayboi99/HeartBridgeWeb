package com.se452.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.se452.model.Profile;
import com.se452.service.ProfileService;
import com.se452.service.UserServiceDao;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();

	}

	/**
	 * @param user_Id
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String name = request.getParameter("user_name");
		String password = request.getParameter("password");
		UserServiceDao us = new UserServiceDao();
		int userId = us.getUser(name).getUserId();
		session.setAttribute("userIdKey", userId);
		session.setAttribute("name", name);
		String url = "";
		String message = "";
		try {
			boolean ifRight = us.verifyExistingUser(name, password);
			if (ifRight == true) {
				ProfileService ps = new ProfileService();
				Profile p = ps.getProfile(userId);
				if (p == null) {
					url = "/UpdateProfile.jsp";
				} else {
					request.setAttribute("aboutMe", p.getAboutMe());
					request.setAttribute("hobby", p.getHobby());
					request.setAttribute("idealPartner", p.getIdealPartner());

					url = "/MyProfile.jsp";
					message = "Welcome " + name + "!";
				}

			} else if (ifRight == false) {
				url = "/Login.jsp";
				message = "Invalid username or password, please try again.";
			}
		} catch (NoSuchAlgorithmException e) {
			url = "/TechniqueIssue.jsp";
		}
		request.setAttribute("message", message);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
		us.finalCommit();
	}
}
